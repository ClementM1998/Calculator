
import java.util.ArrayList;

public class Parser {
    private int currentTokenIndex = 0;
    private ArrayList<Token> tokens;

    public Parser(ArrayList<Token> tokens) {
        this.tokens = tokens;
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

    
}
