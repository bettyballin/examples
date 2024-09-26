import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

public class PBKDF2 {

    public static void main(String[] args) {
        try {
            String password = "iamtwentycharacterss";
            String salt = "50.eGIYr3ZpxpWw67utH17s/A==";
            int iterations = Integer.parseInt(salt.substring(0, salt.indexOf('.')));
            byte[] saltBytes = Base64.getDecoder().decode(salt.substring(salt.indexOf('.') + 1));

            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes, iterations, 512);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            byte[] key = skf.generateSecret(spec).getEncoded();
            String hash = Base64.getEncoder().encodeToString(key);
            System.out.println(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.out.println("ERROR: " + ex);
        }
    }

}