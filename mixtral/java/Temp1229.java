import javax.crypto.Cipher;
import java.security.KeyStore;
import java.security.PrivateKey;

public class Temp1229 {

    public static void main(String[] args) {
        String cipheredText = "YourEncryptedTextHere";
        String alias = "YourAliasHere";
        try {
            String decryptedText = decryptString(alias, cipheredText);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String decryptString(String alias, String cipheredText) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);

        KeyStore.Entry entry = keyStore.getEntry(alias, null);

        if (entry == null || !(entry instanceof KeyStore.PrivateKeyEntry)) {
            throw new Exception("No key found under alias: " + alias);
        }

        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) entry;
        PrivateKey privKey = privateKeyEntry.getPrivateKey();

        Cipher output = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL");
        output.init(Cipher.DECRYPT_MODE, privKey);

        byte[] decodedBytes = java.util.Base64.getDecoder().decode(cipheredText);
        byte[] decryptedBytes = output.doFinal(decodedBytes);

        return new String(decryptedBytes);
    }
}