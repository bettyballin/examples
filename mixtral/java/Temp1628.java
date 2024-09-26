import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.security.interfaces.ECPublicKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;

public class Main {
    public static void main(String[] args) {
        try {
            // Sample public key bytes (replace with actual public key bytes)
            byte[] publicKeyBytes = new byte[]{/* public key bytes here */};

            // Convert byte array to PublicKey
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            PublicKey publicKey = keyFactory.generatePublic(keySpec);

            // Initialize AlgorithmParameters with the public key
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("EC");
            parameters.init(publicKey.getEncoded());

            // Get curve name
            String curveName = ((ECPublicKey) publicKey).getParams().toString();
            System.out.println("Curve Name: " + curveName);

            // Get OID
            ASN1ObjectIdentifier oid = (ASN1ObjectIdentifier) ASN1Primitive.fromByteArray(parameters.getEncoded());
            System.out.println("OID: " + oid.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}