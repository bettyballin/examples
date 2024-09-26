import java.util.Base64;

public class Main94 {
    public static void main(String[] args) {
        String decodedPlaintext = "String to be encoded"; // You should replace with actual string to decode
        String plaintext = Base64.getEncoder().encodeToString(decodedPlaintext.getBytes());
        System.out.println(plaintext);
    }
}