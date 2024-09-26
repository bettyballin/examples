import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.binary.Hex;

public class Temp1126 {
    public static void main(String[] args) {
        try {
            String data = "The quick brown fox jumps over the lazy dog";
            String key = "key";
            
            Mac hmac = Mac.getInstance("HmacSHA1");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA1");
            hmac.init(secretKeySpec);
            
            byte[] result = hmac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            String signature = Hex.encodeHexString(result);
            System.out.println("HMAC-SHA1 Signature : " + signature);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}