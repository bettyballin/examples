import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.*;
import java.io.*;
import javax.crypto.Cipher;

public class McElieceExample {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static PublicKey getMcEliecePublicKeyFromBytes(byte[] publicKeyBytes) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance("McEliece");
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        return keyFactory.generatePublic(publicKeySpec);
    }

    public static void main(String[] args) {
        // Example usage
        // byte[] publicKeyBytes = ...
        // PublicKey publicKey = getMcEliecePublicKeyFromBytes(publicKeyBytes);
    }
}