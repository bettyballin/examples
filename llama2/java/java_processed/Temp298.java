import javax.crypto.Cipher;
import java.security.KeyStore;
import java.security.KeyStore.PrivateKeyEntry;

public class Temp298 {
    public static void main(String[] args) {
        try {
            // Assuming keystore is already loaded and mAlias and encryptedData are defined
            KeyStore ks = KeyStore.getInstance("AndroidKeyStore");
            ks.load(null);

            String mAlias = "your_alias";
            byte[] encryptedData = new byte[]{/* your encrypted data */};

            // Get the private key entry from the key store
            PrivateKeyEntry privateKeyEntry = (PrivateKeyEntry) ks.getEntry(mAlias, null);

            // Create a cipher instance that supports RSA
            Cipher output = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL");

            // Initialize the cipher with the private key
            output.init(Cipher.DECRYPT_MODE, privateKeyEntry.getPrivateKey());

            // Use the cipher to decrypt the data
            byte[] decryptedData = output.doFinal(encryptedData);

            // Print out the decrypted data
            System.out.println(new String(decryptedData, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}