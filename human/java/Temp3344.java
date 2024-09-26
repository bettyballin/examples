import java.nio.charset.StandardCharsets;

public class Temp3344 {
    public static void main(String[] args) {
        byte[] decodedPlaintext = "example".getBytes(StandardCharsets.UTF_8);
        String plaintext = new String(decodedPlaintext, StandardCharsets.UTF_8);
        System.out.println(plaintext);
    }
}