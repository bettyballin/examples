import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.spec.KeySpec;

public class Main99 {
    public static void main(String[] args) {
        try {
            String encodedString = "0O15lUg8sE1G0+BjO5N2j8AjVKXV4J+18z5DinbM6tYjoILhL0WDTFWbcTiN+pG/";
            String passphrase = "my passphrase";
            String salt = "my salt";
            int iterationCount = 65536;
            int keySize = 256;

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), salt.getBytes(), iterationCount, keySize);
            SecretKeySpec secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(new byte[16]));

            byte[] original = cipher.doFinal(Base64.decodeBase64(encodedString));
            String result = new String(original);

            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}