import org.apache.commons.codec.binary.Base64;
import java.nio.charset.StandardCharsets;

public class Temp429 {
    public static void main(String[] args) {
        byte[] hashBytes = "exampleString".getBytes(StandardCharsets.UTF_8);
        String base64Hash = new String(Base64.encodeBase64URLSafe(hashBytes), StandardCharsets.UTF_8);
        System.out.println(base64Hash);
    }
}