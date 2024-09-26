import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Temp123 {
    public static void main(String[] args) {
        String message = "Hello world!";
        byte[] keyBytes = "mysecretkey".getBytes(StandardCharsets.US_ASCII);
        byte[] dataBytes = message.getBytes(StandardCharsets.US_ASCII);
        
        // Just printing the arrays to show they were created successfully
        System.out.println("Key Bytes: " + Arrays.toString(keyBytes));
        System.out.println("Data Bytes: " + Arrays.toString(dataBytes));
    }
}