import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class Temp3609 {
    public static void main(String[] args) {
        try {
            String valueToEncode = "Hello, World!";
            byte[] salt = new byte[16];
            byte[] ivBytes = new byte[16];
            SecureRandom random = new SecureRandom();
            random.nextBytes(salt);
            random.nextBytes(ivBytes);

            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);
            PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, 65536, ivParameterSpec);

            PBEKeySpec keySpec = new PBEKeySpec("some_random_password".toCharArray());
            SecretKeyFactory kf = SecretKeyFactory.getInstance("PBEWITHHMACSHA512ANDAES_256");
            SecretKey secretKey = kf.generateSecret(keySpec);

            Cipher cipher = Cipher.getInstance("PBEWITHHMACSHA512ANDAES_256");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);
            byte[] encValue = cipher.doFinal(valueToEncode.getBytes(StandardCharsets.UTF_8));

            String encodedValue = Base64.getEncoder().encodeToString(encValue);
            System.out.println("Encoded Value: " + encodedValue);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}