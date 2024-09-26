import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.DHParameterSpec;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.interfaces.DHPublicKey;

public class Temp166 {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DiffieHellman");
        kpg.initialize(512);
        KeyPair dkp = kpg.generateKeyPair();
        KeySpec publicKeySpec = new X509EncodedKeySpec(dkp.getPublic().getEncoded());
        KeyFactory kf = KeyFactory.getInstance("DiffieHellman");
        DHPublicKey publicKey = (DHPublicKey) kf.generatePublic(publicKeySpec);
        DHParameterSpec params = publicKey.getParams();

        byte[] rawPublicKeyBytes = publicKey.getY().toByteArray();

        // Print the raw public key bytes in hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (byte b : rawPublicKeyBytes) {
            sb.append(String.format("%02X", b));
        }
        System.out.println(sb.toString());
    }
}