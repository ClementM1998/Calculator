import java.util.ArrayList;

public class Lexer {

    public ArrayList<Token> tokenize(String in) {
        ArrayList<Token> tokens = new ArrayList<>();
        Type type = Type.READ;
        String data = "";
        in = in + '\n';
        for (char c : in.toCharArray()) {
            switch (type) {
                case READ:
                    if (c == ' ') {
                        continue;
                    } else if (isNumber(c)) {
                        data += c;
                        type = Type.NUMBER;
                    } else if (isOperator(c)) {
                        data += c;
                        type = Type.OPERATOR;
                    } else if (isSymbol(c)) {
                        data += c;
                        type = Type.SYMBOL;
                    } else if (c == '\n') {
                        data = "";
                        type = Type.EOF;
                    } else {
                        data += c;
                        type = Type.ERROR;
                    }
                    break;
                case NUMBER:
                    if (c == ' ') {
                        tokens.add(new Token(Type.NUMBER, data));
                        data = "";
                        type = Type.READ;
                    } else if (isNumber(c)) {
                        data += c;
                        type = Type.NUMBER;
                    } else if (isOperator(c)) {
                        tokens.add(new Token(Type.NUMBER, data));
                        data = "";
                        data += c;
                        type = Type.OPERATOR;
                    } else if (isSymbol(c)) {
                        tokens.add(new Token(Type.NUMBER, data));
                        data = "";
                        data += c;
                        type = Type.SYMBOL;
                    } else if (c == '\n') {
                        tokens.add(new Token(Type.NUMBER, data));
                        data = "";
                        type = Type.EOF;
                    } else {
                        data += c;
                        type = Type.ERROR;
                    }
                    break;
                case OPERATOR:
                    if (c == ' ') {
                        tokens.add(new Token(Type.OPERATOR, data));
                        data = "";
                        type = Type.READ;
                    } else if (isNumber(c)) {
                        tokens.add(new Token(Type.OPERATOR, data));
                        data = "";
                        data += c;
                        type = Type.NUMBER;
                    } else if (isOperator(c)) {
                        data += c;
                        type = Type.OPERATOR;
                    } else if (isSymbol(c)) {
                        tokens.add(new Token(Type.OPERATOR, data));
                        data = "";
                        data += c;
                        type = Type.SYMBOL;
                    } else if (c == '\n') {
                        tokens.add(new Token(Type.OPERATOR, data));
                        data = "";
                        type = Type.EOF;
                    } else {
                        data += c;
                        type = Type.ERROR;
                    }
                    break;
                case SYMBOL:
                    if (c == ' ') {
                        tokens.add(new Token(Type.SYMBOL, data));
                        data = "";
                        type = Type.READ;
                    } else if (isNumber(c)) {
                        tokens.add(new Token(Type.SYMBOL, data));
                        data = "";
                        data += c;
                        type = Type.NUMBER;
                    } else if (isOperator(c)) {
                        tokens.add(new Token(Type.SYMBOL, data));
                        data = "";
                        data += c;
                        type = Type.OPERATOR;
                    } else if (isSymbol(c)) {
                        data += c;
                        type = Type.SYMBOL;
                    } else if (c == '\n') {
                        tokens.add(new Token(Type.SYMBOL, data));
                        data = "";
                        data += c;
                        type = Type.EOF;
                    } else {
                        data += c;
                        type = Type.ERROR;
                    }
                    break;
                case EOF:
                    tokens.add(new Token(Type.EOF, ""));
                    break;
                case ERROR:
                    if (c == '\n') {
                        tokens.add(new Token(Type.ERROR, data));
                        data = "";
                        type = Type.EOF;
                    } else {
                        data += c;
                        type = Type.ERROR;
                    }
                    break;
                default:
                    data += c;
                    type = Type.ERROR;
                    break;
            }
        }
        return tokens;
    }

    private boolean isNumber(char c) {
        return (c >= '0' && c <= '9') || c == '.';
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean isSymbol(char c) {
        return c == '(' || c == ')';
    }

}
