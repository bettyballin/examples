import javax.crypto.Cipher;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class Main {
    public static void main(String[] args) {
        byte[] txt = "message".getBytes();
        byte[] encText;
        try {
            // Load the keystore
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            char[] password = "keystorePassword".toCharArray();
            java.io.FileInputStream fis = null;
            try {
                fis = new java.io.FileInputStream("keystore.jks");
                ks.load(fis, password);
            } finally {
                if (fis != null) {
                    fis.close();
                }
            }

            Key rsakey = ks.getKey("mykeyalias", password);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

            // Encrypt
            Certificate cert = ks.getCertificate("mykeyalias");
            try {
                cipher.init(Cipher.ENCRYPT_MODE, cert.getPublicKey());
                encText = cipher.doFinal(txt);
                System.out.println(javax.xml.bind.DatatypeConverter.printHexBinary(encText));
            } catch (Throwable e) {
                e.printStackTrace();
                return;
            }

            // Decrypt
            cipher.init(Cipher.DECRYPT_MODE, rsakey);
            String decrypted = new String(cipher.doFinal(encText));
            System.out.println(decrypted);

        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }
}