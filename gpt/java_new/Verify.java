import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Verify {
  public static void main(String[] args) {
    try {
      PrivateKey priv = //... initialize private key;
      PublicKey pub = //... initialize public key;

      // Convert private key to string
      byte[] privBytes = priv.getEncoded();
      String privKeyString = Base64.getEncoder().encodeToString(privBytes);

      // Convert public key to string
      byte[] pubBytes = pub.getEncoded();
      String pubKeyString = Base64.getEncoder().encodeToString(pubBytes);

      // Store these strings in your database
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}