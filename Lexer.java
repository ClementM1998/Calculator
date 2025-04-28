
import java.util.ArrayList;

public class Lexer {
    private ArrayList<Token> tokens = new ArrayList<Token>();
    private String line;
    private Type type = Type.READ;
    
    public Lexer(String in) {
        this.line = in;
    }

    public ArrayList<Token> tokenize() {
        for (char c : line.toCharArray()) {
            switch (type) {
                case Type.READ:
                    if (c == ' ') continue;
                    else if (isNumber(c)) {
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
                case Type.NUMBER:
                    break;
                case Type.OPERATOR:
                    break;
                case Type.SYMBOL:
                    break;
                case Type.EOF:
                    break;
                case Type.ERROR:
                    if (c == '\n') {
                        tokens.add(new Token(Type.ERROR, data));
                        data = "";
                        type = Type.EOF;
                    } else {
                        data += c;
                        type = Type.ERROR;
                    }
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
