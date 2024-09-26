import de.flexiprovider.api.keys.KeyFactory;
import de.flexiprovider.pqc.ecc.mceliece.McEliecePrivateKeySpec;
import de.flexiprovider.pqc.ecc.mceliece.McEliecePublicKeySpec;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Temp193 {
    public static void main(String[] args) {
        // Example usage
        byte[] privateKey = {}; // Add actual private key bytes
        byte[] publicKey = {};  // Add actual public key bytes
        KeyPair keyPair = readKeyPair(privateKey, publicKey);
        if (keyPair != null) {
            System.out.println("KeyPair generated successfully.");
        }
    }

    public static KeyPair readKeyPair(byte[] privateKey, byte[] publicKey) {
        try {
            McEliecePrivateKeySpec mcEliecePrivateKeySpec = new McEliecePrivateKeySpec(privateKey);
            McEliecePublicKeySpec mcEliecePublicKeySpec = new McEliecePublicKeySpec(publicKey);

            KeyFactory keyFactory = KeyFactory.getInstance("McEliece", "FlexiPQC");
            PrivateKey privateKeyObj = keyFactory.generatePrivate(mcEliecePrivateKeySpec);
            PublicKey publicKeyObj = keyFactory.generatePublic(mcEliecePublicKeySpec);

            return new KeyPair(publicKeyObj, privateKeyObj);
        } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeySpecException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}