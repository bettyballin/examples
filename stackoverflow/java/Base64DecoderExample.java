import java.util.Base64;

public class Base64DecoderExample {
    public static void main(String[] args) {
        String key = "yourBase64UrlEncodedStringHere";
        final Base64.Decoder decoder = Base64.getUrlDecoder();
        final byte[] decoded = decoder.decode(key);
        // Use the decoded bytes as needed
    }
}