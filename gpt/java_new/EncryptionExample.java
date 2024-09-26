import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwk.PublicJsonWebKey;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.lang.JoseException;
import java.security.Key;
import java.util.Base64;

public class EncryptionExample {

    public void testEncryptionWithJose4j() {
        String sharedSecret = "LyQnklSrxsk3Ch2+AHi9HoDW@//x1LwM123QP/ln";
        byte[] sharedSecretBytes = Base64.getDecoder().decode(sharedSecret.getBytes());

        try {
            // Generate a symmetric key (CEK) to be wrapped
            Key cek = new AesKey(sharedSecretBytes);

            // Create a new JsonWebEncryption object
            JsonWebEncryption jwe = new JsonWebEncryption();

            // Set the payload, the message to be encrypted
            jwe.setPayload("Hello World!");

            // Set the algorithm constraints
            jwe.setAlgorithmConstraints(new AlgorithmConstraints(AlgorithmConstraints.ConstraintType.PERMIT, 
                KeyManagementAlgorithmIdentifiers.DIRECT));
            jwe.setContentEncryptionAlgorithmConstraints(new AlgorithmConstraints(AlgorithmConstraints.ConstraintType.PERMIT, 
                ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256));

            // Set the encryption key
            jwe.setKey(cek);

            // Produce the encrypted JWE representation of the payload
            String serializedJwe = jwe.getCompactSerialization();
            System.out.println("Encrypted: " + serializedJwe);
        } catch (JoseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EncryptionExample example = new EncryptionExample();
        example.testEncryptionWithJose4j();
    }
}