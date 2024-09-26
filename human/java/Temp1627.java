import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Base64;

public class Temp1627 {
    private static final Base64.Decoder BASE_64_DECODER = Base64.getDecoder();
    private static final String ENCODING = "UTF-8";

    public static void main(String[] args) {
        Temp1627 temp = new Temp1627();
        char[] password = "examplePassword".toCharArray();
        byte[] decodedPassword = temp.decodePassword(password);
        System.out.println(new String(decodedPassword));
    }

    private byte[] decodePassword(char[] password) {
        CharBuffer charBuffer = CharBuffer.wrap(password);
        ByteBuffer byteBuffer = Charset.forName(ENCODING).encode(charBuffer);
        return BASE_64_DECODER.decode(byteBuffer);
    }
}