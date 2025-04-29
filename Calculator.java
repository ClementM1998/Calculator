
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Lexer lexer = new Lexer();
        Parser parser;

        while (true) {
            System.out.print("Calculator > ");
            String in = scanner.nextLine().toLowerCase();
            if (in.equals("exit")) break;
            parser = new Parser(lexer.tokenize(in));
            Object value = parser.execute();
            if (value != null) System.out.println(value + " #");
        }
        
    }
}
