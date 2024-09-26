import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Temp15 {
    public static void main(String[] args) {
        try {
            // Generate a key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair pair = keyGen.generateKeyPair();
            PublicKey publicKey = pair.getPublic();
            PrivateKey privateKey = pair.getPrivate();

            // Save the keys to a file
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("keys.dat"));
            oos.writeObject(publicKey);
            oos.writeObject(privateKey);
            oos.close();
            
            System.out.println("Keys have been saved to keys.dat");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}