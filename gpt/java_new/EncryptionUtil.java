import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import java.security.spec.MGF1ParameterSpec;

public class EncryptionUtil {

    public static void main(String[] args) {
        try {
            // Assume publicKey is an instance of RSAPublicKey you've already initialized.
            RSAPublicKey publicKey = /* initialize your public key here */;
            
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
            OAEPParameterSpec oaepParams = new OAEPParameterSpec("SHA-1", "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey, oaepParams);
            
            // Assuming there is a byte array to encrypt, named 'dataToEncrypt'
            byte[] dataToEncrypt = /* your data to encrypt */;
            byte[] encryptedData = cipher.doFinal(dataToEncrypt);
            
            // ... handle the encrypted data
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}