import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.Cipher;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import static java.nio.charset.StandardCharsets.US_ASCII;

public class Main88 {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();

        OAEPParameterSpec spec = new OAEPParameterSpec("SHA-1", "MGF1", MGF1ParameterSpec.SHA1,
                new PSource.PSpecified("label".getBytes(US_ASCII)));

        OAEPParameterSpec specEmpty = new OAEPParameterSpec("SHA-1", "MGF1", MGF1ParameterSpec.SHA1,
                PSource.PSpecified.DEFAULT);

        byte[] ct;
        {
            Cipher rsaOAEPEnc = Cipher.getInstance("RSA/ECB/OAEPPadding");
            rsaOAEPEnc.init(Cipher.ENCRYPT_MODE, kp.getPublic(), spec);
            ct = rsaOAEPEnc.doFinal("owlstead".getBytes(US_ASCII));
        }

        {
            Cipher rsaOAEPDec = Cipher.getInstance("RSA/ECB/OAEPPadding");
            rsaOAEPDec.init(Cipher.DECRYPT_MODE, kp.getPrivate(), spec);
            byte[] pt = rsaOAEPDec.doFinal(ct);
            System.out.println(new String(pt, US_ASCII));
        }

        {
            Cipher rsaOAEPDec = Cipher.getInstance("RSA/ECB/OAEPPadding");
            rsaOAEPDec.init(Cipher.DECRYPT_MODE, kp.getPrivate(), specEmpty);
            try {
                byte[] pt = rsaOAEPDec.doFinal(ct);
                System.out.println(new String(pt, US_ASCII));
            } catch (Exception e) {
                System.out.println("Decryption failed: " + e.getMessage());
            }
        }
    }
}