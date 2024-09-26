import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

public class KeySaver1 {
    public static void saveKeys(KeyPair kp, String path, String[] args) throws IOException {
        // Save the public key in X.509 format
        try (FileOutputStream fos = new FileOutputStream(path + args[0] + ".pub")) {
            byte[] publicKeyBytes = kp.getPublic().getEncoded();
            fos.write(publicKeyBytes);
        }

        // Save the private key in PKCS#8 format
        try (FileOutputStream fos = new FileOutputStream(path + args[0] + ".prv")) {
            byte[] privateKeyBytes = kp.getPrivate().getEncoded();
            fos.write(privateKeyBytes);
        }
    }
}