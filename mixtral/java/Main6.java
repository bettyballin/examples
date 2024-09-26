import javax.crypto.*;
import java.security.*;
import java.security.spec.*;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        String pem = "-----BEGIN EC PRIVATE KEY-----\n" +
                     "<base64 data here>\n" +
                     "-----END EC PRIVATE KEY-----";

        // Remove header and footer
        pem = pem.replace("-----BEGIN EC PRIVATE KEY-----\n", "");
        pem = pem.replace("-----END EC PRIVATE KEY-----", "");
        pem = pem.replace("\n", "");

        // Decode Base64
        byte[] der = Base64.getDecoder().decode(pem);

        // Parse DER structure
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(der);

        PrivateKey privateKey = keyFactory.generatePrivate(spec);

        System.out.println("Private Key: " + privateKey);
    }
}