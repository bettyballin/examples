import javax.crypto.Cipher;
import java.security.KeyStore;
import java.security.PublicKey;

public class Temp1228 {
    public static void main(String[] args) {
        try {
            String encryptedText = encryptString("alias", "textToEncrypt");
            System.out.println("Encrypted Text: " + encryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encryptString(String alias, String textToEncrypt) throws Exception {
        // Load the keystore
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);

        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(alias, null);

        Cipher input = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL");

        /* Use the public key from Private Key Entry for encryption */
        PublicKey pubKey = privateKeyEntry.getCertificate().getPublicKey();

        input.init(Cipher.ENCRYPT_MODE, pubKey);

        byte[] encryptedBytes = input.doFinal(textToEncrypt.getBytes("UTF-8"));
        return android.util.Base64.encodeToString(encryptedBytes, android.util.Base64.DEFAULT);
    }
}