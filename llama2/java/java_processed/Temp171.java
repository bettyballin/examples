import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Base64;

public class Temp171 {
    public static void main(String[] args) {
        try {
            // Generate a Diffie-Hellman key pair
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("DiffieHellman");
            kpg.initialize(512);
            KeyPair dkp = kpg.generateKeyPair();

            // Get the public key
            PublicKey pubKey = dkp.getPublic();

            // Encode the public key to a byte array
            byte[] encodedPubKey = pubKey.getEncoded();

            // Decode the encoded public key is not needed, getEncoded() does not Base64 encode
            System.out.println("Encoded key bytes: " + Arrays.toString(encodedPubKey));

            // If you want to see what it looks like in Base64
            String base64Encoded = Base64.getEncoder().encodeToString(encodedPubKey);
            System.out.println("Base64 encoded key: " + base64Encoded);

            // But in this case, you can not decode the public key bytes like that
            // this is incorrect: byte[] rawKeyBytes = Base64.getDecoder().decode(encodedPubKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}