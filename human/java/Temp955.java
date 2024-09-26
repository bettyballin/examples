import java.util.Base64;

public class Temp955 {
    public static void main(String[] args) {
        String string = "Hello, World!";
        String encodedString = Base64.getMimeEncoder().encodeToString(string.getBytes());
        System.out.println(encodedString);
    }
}