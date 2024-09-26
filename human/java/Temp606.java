import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class Temp606 {
    public static void main(String[] args) {
        try {
            // Generate a public key for demonstration purposes
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            
            byte[] encoded = publicKey.getEncoded();
            SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(
                    ASN1Sequence.getInstance(encoded));
            byte[] otherEncoded = subjectPublicKeyInfo.parsePublicKey().getEncoded();
            
            // Print the encoded key to show some output
            System.out.println(java.util.Arrays.toString(otherEncoded));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}