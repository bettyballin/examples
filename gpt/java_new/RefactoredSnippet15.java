import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.Certificate;

public class RefactoredSnippet15 {
    public static void main(String[] args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("Windows-MY");
        keyStore.load(null, null); // No InputStream or password required for Windows-MY
        String alias = "yourKeyAlias"; // The alias for the key you want to use
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, null); // No password required for private keys in Windows-MY
        Certificate certificate = keyStore.getCertificate(alias);
        Signature signature = Signature.getInstance("SHA256withRSA"); // Use appropriate algorithm
        signature.initSign(privateKey);
        byte[] dataToSign = "Your data to sign".getBytes();
        signature.update(dataToSign);
        byte[] digitalSignature = signature.sign();
        // Now 'digitalSignature' contains the signed data
    }
}