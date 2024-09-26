import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Temp1350 {
    public static void main(String[] args) {
        String data = "Hello, World!";
        String encodedData = Base64.getEncoder().encodeToString(data.getBytes(StandardCharsets.UTF_8));
        System.out.println(encodedData);
    }
}