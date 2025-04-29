
public class Arithmetic {
    private Object left;
    private Object right;
    private String operator;

    public Arithmetic(Object left, String operator, Object right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    private Object resultArithmetic() {
        if (left instanceof Double) {
            switch (operator) {
                case "+":
                    return Double.parseDouble(left) + Integer.parseInt(right);
                case "-":
                    return Double.parseDouble(left) - Integer.parseInt(right);
                case "*":
                    return Double.parseDouble(left) * Integer.parseInt(right);
                case "/":
                    return Double.parseDouble(left) / Integer.parseInt(right);
            }
        } else if (right instanceof Double) {
            switch (operator) {
                case "+":
                    return Integer.parseInt(left) + Double.parseDouble(right);
                case "-":
                    return Integer.parseInt(left) - Double.parseDouble(right);
                case "*":
                    return Integer.parseInt(left) * Double.parseDouble(right);
                case "/":
                    return Integer.parseInt(left) / Double.parseDouble(right);
            }
        } else {
            switch (operator) {
                case "+":
                    return Integer.parseInt(left) + Integer.parseInt(right);
                case "-":
                    return Integer.parseInt(left) - Integer.parseInt(right);
                case "*":
                    return Integer.parseInt(left) * Integer.parseInt(right);
                case "/":
                    return Integer.parseInt(left) / Integer.parseInt(right);
            }
        }
    }

    public String toString() {
        return resultArithmetic();
    }
    
}
