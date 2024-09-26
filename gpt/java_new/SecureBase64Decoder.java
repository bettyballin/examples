import java.util.Base64;

public class SecureBase64Decoder {

    public static byte[] decodeBase64CharArray(char[] base64Chars) {
        String base64String = new String(base64Chars);
        return Base64.getDecoder().decode(base64String);
    }
}