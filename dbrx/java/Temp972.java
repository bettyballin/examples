import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;
import java.security.interfaces.RSAPrivateKey;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Temp972 {
    public static void main(String[] args) {
        try {
            String PRIVATE_KEY_FILE_RSA = "src/pri.der";
            File privKeyFile = new File(PRIVATE_KEY_FILE_RSA);

            // read private key DER file
            DataInputStream dis = new DataInputStream(new FileInputStream(privKeyFile));
            byte[] privKeyBytes = new byte[(int) privKeyFile.length()];
            dis.read(privKeyBytes);
            dis.close();

            String passphrase = "your_passphrase_here";
            byte[] salt = new byte[8]; // Initialize with your salt value
            int iterationCount = 1000; // Example iteration count

            KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), salt, iterationCount);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            byte[] keyBytes = factory.generateSecret(spec).getEncoded();
            PKCS8EncodedKeySpec privSpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            RSAPrivateKey privKey = (RSAPrivateKey) kf.generatePrivate(privSpec);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}