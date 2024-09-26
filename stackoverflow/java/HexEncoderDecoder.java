import java.nio.charset.StandardCharsets;
import java.util.HexFormat;

public class HexEncoderDecoder {

    public static void main(String[] args) {
        String input = "hello world";

        // Encoding
        String encoded = HexFormat.of().formatHex(input.getBytes(StandardCharsets.UTF_8));
        System.out.println(encoded);

        // Decoding
        byte[] decodedBytes = HexFormat.of().parseHex(encoded);
        String decoded = new String(decodedBytes, StandardCharsets.UTF_8);
        System.out.println(decoded);
    }
}