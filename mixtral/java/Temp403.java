import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

public class Temp403 {
    public static void main(String[] args) {
        try {
            FileInputStream fis1 = new FileInputStream("privateKey.der");
            DataInputStream dis1 = new DataInputStream(fis1);
            byte[] keyBytes1 = new byte[dis1.available()];
            dis1.readFully(keyBytes1);
            dis1.close();

            PKCS8EncodedKeySpec spec1 = new PKCS8EncodedKeySpec(keyBytes1);
            PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(spec1);
            
            // Just to ensure the private key is read correctly, we print its algorithm
            System.out.println("Private Key Algorithm: " + privateKey.getAlgorithm());
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}