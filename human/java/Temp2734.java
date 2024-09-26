import java.nio.charset.StandardCharsets;

public class Temp2734 {
    public static void main(String[] args) {
        byte[] bytes = "SessionKeyMaterial".getBytes(StandardCharsets.US_ASCII);
        for (byte b : bytes) {
            System.out.print(b + " ");
        }
    }
}