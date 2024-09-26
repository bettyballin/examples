import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class HmacExample {
    public static void main(String[] args) {
        try {
            String id1 = "exampleId1";
            String id2 = "exampleId2";
            String id3 = "exampleId3";
            byte[] buffer = "secretKey".getBytes(StandardCharsets.UTF_8);

            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(buffer, "HmacSHA256");
            mac.init(secretKeySpec);

            mac.update(id1.getBytes(StandardCharsets.UTF_8));
            mac.update(id2.getBytes(StandardCharsets.UTF_8));
            mac.update(id3.getBytes(StandardCharsets.UTF_8));

            byte[] result = mac.doFinal();
            String token = Base64.getUrlEncoder().withoutPadding().encodeToString(result);

            System.out.println(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}