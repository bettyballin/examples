import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Temp123 {
    public static void main(String[] args) {
        try {
            Temp123 temp = new Temp123();
            String result = temp.sha1("Hello, World!", "key123");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String sha1(String s, String keyString) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(key);

        byte[] bytes = mac.doFinal(s.getBytes("UTF-8"));

        return Base64.getEncoder().encodeToString(bytes);
    }
}