
public class Token {
    public String data;
    public Type type;

    public Token(Type type, String data) {
        this.type = type;
        this.data = data;
    }

    public String toString() {
        return "[" + type + "," + data + "]";
    }

}
