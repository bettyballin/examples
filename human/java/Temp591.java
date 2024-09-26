import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Temp591 {
    public static void main(String[] args) {
        try {
            String token = "5f1fa09364a6ae7e35a090b434f182652ab8dd76:{\"expiration\": 1353759442.0991001, \"channel\": \"dreamhacksc2\", \"user_agent\": \".*";
            String privateKey = "Wd75Yj9sS26Lmhve";

            Mac hmacSha1 = Mac.getInstance("HmacSHA1");
            SecretKeySpec keySpec = new SecretKeySpec(privateKey.getBytes(StandardCharsets.UTF_8), "HmacSHA1");
            hmacSha1.init(keySpec);

            byte[] result = hmacSha1.doFinal(token.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : result) {
                hexString.append(String.format("%02x", b));
            }

            System.out.println(hexString.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}