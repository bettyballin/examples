import java.util.Base64;

public class Encoder {
    public static String encodeString(String string) {
        return Base64.getMimeEncoder().encodeToString(string.getBytes());
    }

    public static void main(String[] args) {
        String originalString = "This is a string to be encoded.";
        String encodedString = encodeString(originalString);
        System.out.println(encodedString);
    }
}