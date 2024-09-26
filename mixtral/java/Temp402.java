import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class Temp402 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("publicKey.der");
            DataInputStream dis = new DataInputStream(fis);
            byte[] keyBytes = new byte[dis.available()];
            dis.readFully(keyBytes);
            dis.close();

            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(spec);

            // Use the publicKey object as needed

        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}