import java.util.ArrayList;

public class Parser {
    private ArrayList<Token> tokens;
    private Object result;
    private int currentTokenIndex = 0;

    public Parser(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    public Object execute() {
        try {
            return parseExpression();
        } catch (RuntimeException e) {
            System.out.println("SYNTAX ERROR IN LINE : " + e.getMessage());
            return null;
        }
    }

    private Object parseExpression() {
        return parseTerm();
    }

    private Object parseTerm() {
        Object left = parseFactor();
        while (match(Type.OPERATOR) && (peek().data.equals("+") || peek().data.equals("-"))) {
            String operator = consume(Type.OPERATOR).data;
            Object right = parseFactor();
            if (operator.equals("+")) left = new Arithmetic(left, "+", right);
            else if (operator.equals("-")) left = new Arithmetic(left, "-", right);
        }
        return left;
    }

    private Object parseFactor() {
        Object left = parsePrimary();
        while (match(Type.OPERATOR) && (peek().data.equals("*") || peek().data.equals("/"))) {
            String operator = consume(Type.OPERATOR).data;
            Object right = parsePrimary();
            if (operator.equals("*")) left = new Arithmetic(left, "*", right);
            else if (operator.equals("/")) left = new Arithmetic(left, "/", right);
        }
        return left;
    }

    private Object parsePrimary() {
        if (match(Type.SYMBOL) && peek().data.equals("(")) {
            consume(Type.SYMBOL);
            Object expression = parseExpression();
            if (!match(Type.SYMBOL) || !peek().data.equals(")")) {
                throw new RuntimeException("Expected ')' but found: " + peek().data);
            }
            consume(Type.SYMBOL);
            return expression;
        }
        boolean isNegative = false;
        if (match(Type.OPERATOR) && peek().data.equals("-")) {
            consume(Type.OPERATOR);
            isNegative = true;
        }
        Token token = consume(Type.NUMBER);
        switch (token.type) {
            case NUMBER:
                Object number;
                if (token.data.contains(".")) number = Double.parseDouble(token.data);
                else number = Integer.parseInt(token.data);
                return isNegative ? new Arithmetic(0, "-", number) : number;
            default:
                throw new RuntimeException("Invalid primary expression: " + token.data);
        }
    }

    private Token consume(Type ... types) {
        if (currentTokenIndex >= tokens.size()) throw new RuntimeException("Unexpected end of tokens");
        Token token = tokens.get(currentTokenIndex++);
        for (Type type : types) {
            if (token.type == type) return token;
        }
        throw new RuntimeException("Unexpected token: CONSUME " + token);
    }

    private Token peek() {
        if (currentTokenIndex >= tokens.size()) return new Token(Type.EOF, "");
        return tokens.get(currentTokenIndex);
    }

    private boolean match(Type type) {
        return currentTokenIndex < tokens.size() && tokens.get(currentTokenIndex).type == type;
    }

    private boolean matchAndConsume(Type type) {
        if (match(type)) {
            currentTokenIndex++;
            return true;
        }
        return false;
    }

}
