import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;

public class Temp751 {
    public static void main(String[] args) {
        String hexToken = "your_hex_string_here";
        byte[] decodedBytes = javax.xml.bind.DatatypeConverter.parseHexBinary(hexToken);
        String accessToken = new String(decodedBytes, java.nio.charset.StandardCharsets.UTF_8);
        System.out.println(accessToken);
    }
}