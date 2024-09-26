import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import java.util.Base64;

public class Temp748 {

    public static void main(String[] args) {
        try {
            String modulusString = "hm2oRCtP6usJKYpq7o1K20uUuL11j5xRrbV4FCQhn/JeXLT21laKK9901P69YUS3bLo64x8G1PkCfRtjbbZCIaa1Ci/BCQX8nF2kZVfrPyzcmeAkq4wsDthuZ+jPInknzUI3TQPAzdj6gim97E731i6WP0MHFqW6ODeQ6Dsp8pc=";
            String publicExponentString = "AQAB";
            String clearTextPassword = "your_password_here"; // Replace with actual password

            byte[] modulusBytes = Base64.getDecoder().decode(modulusString);
            byte[] exponentBytes = Base64.getDecoder().decode(publicExponentString);
            BigInteger modulus = new BigInteger(1, modulusBytes);
            BigInteger publicExponent = new BigInteger(1, exponentBytes);

            RSAPublicKeySpec rsaPubKey = new RSAPublicKeySpec(modulus, publicExponent);
            KeyFactory fact = KeyFactory.getInstance("RSA");
            PublicKey pubKey = fact.generatePublic(rsaPubKey);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);

            byte[] plainBytes = clearTextPassword.getBytes("UTF-16LE");
            byte[] cipherData = cipher.doFinal(plainBytes);
            String encryptedStringBase64 = Base64.getEncoder().encodeToString(cipherData);

            System.out.println(encryptedStringBase64);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}