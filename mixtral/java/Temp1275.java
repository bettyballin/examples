import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        String hex = "8E383187C7ACFAB214B113444EA248DC34BADCB...6F586E4CD86";

        byte[] bytes = toByteArray(hex);

        // Specify the encoding when creating a String from bytes
        String encryptedText = new String(bytes, StandardCharsets.UTF_8);

        System.out.println("Encrypted Text: " + encryptedText);
    }

    public static byte[] toByteArray(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                                 + Character.digit(hexString.charAt(i+1), 16));
        }
        return data;
    }
}