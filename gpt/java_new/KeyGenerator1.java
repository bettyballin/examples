import java.util.Base64;
import org.junit.Test;

public class KeyGenerator1 {

  @Test
  public void testGenerateECKey() {
    try {
      // ... existing key generation code ...
      // Assume publicKey is generated here

      // Encode the public key
      String publicKeyPEM = Base64.getEncoder().encodeToString(publicKey.getEncoded());
      
      // Print the public key in PEM format
      System.out.println("-----BEGIN PUBLIC KEY-----
" + publicKeyPEM + "
-----END PUBLIC KEY-----");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}