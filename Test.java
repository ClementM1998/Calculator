
public class Test {
    public static void main(String[] args) {

        String text = "(2+3)*(4-1)/5";
        Lexer lexer = new Lexer();
        Parser parser = new Parser(lexer.tokenize(text));
        Object value = parser.execute();
        System.out.println("Result: " + value + " #");
        
    }
}
