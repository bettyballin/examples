import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Signature;

public class Temp1 {
    public static void main(String[] args) {
        try {
            KeyStore ks = KeyStore.getInstance("SunMSCAPI");
            ks.load(null);
            Provider p = ks.getProvider();

            Signature sig = Signature.getInstance("SHA1withRSA");
            String alias = ks.aliases().nextElement(); // Get an alias from the keystore
            PrivateKey key = (PrivateKey) ks.getKey(alias, null);

            sig.initSign(key);
            sig.update("Testing".getBytes());
            byte[] signature = sig.sign();

            System.out.println("Signature: " + bytesToHex(signature));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Utility method to convert byte array to hex string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}