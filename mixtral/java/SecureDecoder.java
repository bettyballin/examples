import javax.crypto.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.util.Base64;

public class SecureDecoder {
    public static void main(String[] args) throws NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException, ShortBufferException, InvalidKeyException {
        char[] password = {'a', ' ', 'b', 'c'};

        // Convert to byte array
        byte[] bytes = new String(password).getBytes(StandardCharsets.UTF_8);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        Base64.Decoder decoder = Base64.getMimeDecoder();

        // Decode the encoded password
        byte[] decodedBytes = decoder.decode(bytes);

        // Write the decoded bytes to the output stream
        outputStream.write(decodedBytes);

        byte[] resultBytes = outputStream.toByteArray();

        // Print the result
        System.out.println(new String(resultBytes, StandardCharsets.UTF_8));
    }
}