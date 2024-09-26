import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Temp1991 {
    public static void main(String[] args) {
        try {
            String password = "yourPassword";
            byte[] salt = "yourSalt".getBytes();
            int iterations = 10000;
            int bitlen = 256;

            SecretKeyFactory kf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            KeySpec ks = new PBEKeySpec(password.toCharArray(), salt, iterations, bitlen);
            byte[] key = kf.generateSecret(ks).getEncoded();

            System.out.println(Base64.getEncoder().encodeToString(key));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}