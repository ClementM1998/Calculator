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
            else if (in.equals("clear")) {
                String os = System.getProperty("os.name").toLowerCase();
                try {
                    if (os.contains("win")) {
                        // Untuk Windows
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } else {
                        // Untuk Linux dan Mac
                        new ProcessBuilder("clear").inheritIO().start().waitFor();
                    }
                } catch (Exception e) {
                    System.out.println("Screen can't clear");
                }
            } else {
                parser = new Parser(lexer.tokenize(in));
                Object value = parser.execute();
                if (value != null) System.out.println(value + " #");
            }
        }

    }
}
