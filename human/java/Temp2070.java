import java.util.Base64;

public class Temp2070 {
    public static void main(String[] args) {
        String msgText = "SGVsbG8gd29ybGQh"; // Example base64 encoded string
        byte[] data = Base64.getDecoder().decode(msgText);
        
        // Print the decoded data as a string
        String decodedString = new String(data);
        System.out.println(decodedString);
    }
}