import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Temp16 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("keys.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            PublicKey publicKey = (PublicKey) ois.readObject();
            PrivateKey privateKey = (PrivateKey) ois.readObject();

            ois.close();
            
            // Additional code can be added here to use the keys
            System.out.println("Public Key: " + publicKey);
            System.out.println("Private Key: " + privateKey);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}