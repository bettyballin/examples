import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.JsonWebEncryption.Header;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.keys.AesKey;
import java.security.Key;
import java.util.Base64;

public class Temp765 {
    public static void main(String[] args) {
        try {
            JsonWebEncryption jwe = new JsonWebEncryption();
            jwe.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.A256KW);
            jwe.setEncryptionMethodHeaderParameter("A128GCM");

            byte[] ivBytes = new byte[12]; // example initialization, should be properly initialized
            jwe.setHeader("iv", Base64.getUrlEncoder().withoutPadding().encodeToString(ivBytes));

            Key aesKey = new AesKey(new byte[32]); // example initialization, should be properly initialized
            byte[] encryptedCek = jwe.getHeaders().getEncryptedCEK(aesKey, "A128GCM");

            System.out.println("Encrypted CEK: " + Base64.getUrlEncoder().withoutPadding().encodeToString(encryptedCek));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}