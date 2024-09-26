import java.nio.charset.StandardCharsets;

public class Temp3560 {
    public static void main(String[] args) {
        byte[] id1 = "1001".getBytes(StandardCharsets.UTF_8);
        byte[] id2 = "2002".getBytes(StandardCharsets.UTF_8);
        byte[] id3 = "3003".getBytes(StandardCharsets.UTF_8);
        byte[] buffer = "very-secret-key".getBytes(StandardCharsets.UTF_8);
        
        // Output to verify the byte arrays
        System.out.println(new String(id1, StandardCharsets.UTF_8));
        System.out.println(new String(id2, StandardCharsets.UTF_8));
        System.out.println(new String(id3, StandardCharsets.UTF_8));
        System.out.println(new String(buffer, StandardCharsets.UTF_8));
    }
}