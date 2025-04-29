
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
        switch (operator) {
            case "+":
                if (left instanceof Double) return Double.parseDouble(left.toString()) + Integer.parseInt(right.toString());
                else if (right instanceof Double) return Integer.parseInt(left.toString()) + Double.parseDouble(right.toString());
                else return Integer.parseInt(left.toString()) + Integer.parseInt(right.toString());
            case "-":
                if (left instanceof Double) return Double.parseDouble(left.toString()) - Integer.parseInt(right.toString());
                else if (right instanceof Double) return Integer.parseInt(left.toString()) - Double.parseDouble(right.toString());
                else return Integer.parseInt(left.toString()) - Integer.parseInt(right.toString());
            case "*":
                if (left instanceof Double) return Double.parseDouble(left.toString()) * Integer.parseInt(right.toString());
                else if (right instanceof Double) return Integer.parseInt(left.toString()) * Double.parseDouble(right.toString());
                else return Integer.parseInt(left.toString()) * Integer.parseInt(right.toString());
            case "/":
                //if (left instanceof Double) return Double.parseDouble(left.toString()) / Integer.parseInt(right.toString());
                //else if (right instanceof Double) return Integer.parseInt(left.toString()) / Double.parseDouble(right.toString());
                //else return Integer.parseInt(left.toString()) / Integer.parseInt(right.toString());
                return Double.parseDouble(left.toString()) / Double.parseDouble(right.toString());
        }
        throw new RuntimeException("Unexcepted operator");
    }

    public String toString() {
        Object o = resultArithmetic();
        return String.valueOf(o);
    }

}
