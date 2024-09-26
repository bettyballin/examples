import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import java.util.Base64;

public class Temp110 {
    public static void main(String[] args) throws Exception {

        // my clear text password
        String clearTextPassword = "XXXXX";

        // these are the actual values I get from the web service team
        String modulusString = "hm2oRCtP6usJKYpq7o1K20uUuL11j5xRrbV4FCQhn/JeXLT21laKK9901P69YUS3bLo64x8G1PkCfRtjbbZCIaa1Ci/BCQX8nF2kZVfrPyzcmeAkq4wsDthuZ+jPInknzUI3TQPAzdj6gim97E731i6WP0MHFqW6ODeQ6Dsp8pc=";
        String publicExponentString = "AQAB";

        Base64.Decoder base64Decoder = Base64.getDecoder();

        byte[] modulusBytes = base64Decoder.decode(modulusString);
        BigInteger modulus = new BigInteger(1, modulusBytes);

        byte[] publicExponentBytes = base64Decoder.decode(publicExponentString);
        BigInteger publicExponent = new BigInteger(1, publicExponentBytes);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(modulus, publicExponent);
        PublicKey publicKey = keyFactory.generatePublic(rsaPublicKeySpec);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] clearTextBytes = clearTextPassword.getBytes("UTF-16LE"); // Use UTF-16 Little Endian

        byte[] encryptedBytes = cipher.doFinal(clearTextBytes);

        // Printing the encrypted output for verification
        System.out.println(Base64.getEncoder().encodeToString(encryptedBytes));
    }
}