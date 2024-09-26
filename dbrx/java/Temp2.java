import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Signature;

public class Temp2 {
    public static void main(String[] args) throws Exception {
        String alias = "Alias to my PK";
        char[] pass = null; // No password needed for loading the keystore.

        KeyStore ks = KeyStore.getInstance("Windows-MY", "SunMSCAPI");
        ks.load(null, pass); // Load without a password.
        Provider p = ks.getProvider();

        Signature sig = Signature.getInstance("SHA1withRSA");
        PrivateKey key = (PrivateKey) ks.getKey(alias, null); // No need for the password here either.

        sig.initSign(key);
        sig.update("Testing".getBytes());
        byte[] signatureBytes = sig.sign();

        // Printing the signature in hexadecimal format
        System.out.println(bytesToHex(signatureBytes));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}