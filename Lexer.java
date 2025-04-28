
import java.util.ArrayList;

public class Lexer {
    private ArrayList<Token> tokens = new ArrayList<Token>();
    private String line;
    
    public Lexer(String in) {
        this.line = in;
    }

    public ArrayList<Token> tokenize() {
        for (char c : line.toCharArray()) {
            if (
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
