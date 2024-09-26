import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Temp1232 {
    public static void main(String[] args) {
        String c = "Hello, World!";
        String cBase64 = Base64.getEncoder().encodeToString(c.getBytes(StandardCharsets.UTF_8));
        System.out.println(cBase64);
    }
}