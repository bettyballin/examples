import java.util.Base64;

public class Temp1851 {
    public static void main(String[] args) {
        final String key = "exampleKey"; // Add a base64 encoded string here
        final Base64.Decoder decoder = Base64.getUrlDecoder();
        final byte[] decoded = decoder.decode(key.getBytes());

        // Print the decoded bytes as a string
        System.out.println(new String(decoded));
    }
}