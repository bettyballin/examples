import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Temp868 {

    public static void main(String[] args) {
        try {
            byte[] msg = "Hello, World!".getBytes();
            byte[] keyin = "secret".getBytes();
            String result = hmacsha1Digest(msg, keyin);
            System.out.println(result);
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String hmacsha1Digest(byte[] msg, byte[] keyin) throws InvalidKeyException, NoSuchAlgorithmException {
        SecretKeySpec key = new SecretKeySpec(keyin, "HmacSHA1");

        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(key);

        byte[] bytes = mac.doFinal(msg);

        StringBuffer hash = new StringBuffer();
        for (int i = 0; i < bytes.length; ++i) {
            int v = bytes[i] & 0xFF;
            if (v < 16) {
                hash.append('0');
            }
            hash.append(Integer.toHexString(v));
        }

        return hash.toString();
    }
}