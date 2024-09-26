import org.springframework.util.Base64Utils;

public class Example2 {
    public static void main(String[] args) {
        String originalInput = "This is a test string.";
        String encodedString = Base64Utils.encodeToString(originalInput.getBytes());
        String decodedString = new String(Base64Utils.decodeFromString(encodedString));

        System.out.println("Original Input: " + originalInput);
        System.out.println("Encoded String: " + encodedString);
        System.out.println("Decoded String: " + decodedString);
    }
}