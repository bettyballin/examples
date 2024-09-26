import javax.crypto.Cipher;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Temp3445 {
    public static void main(String[] args) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            System.out.println("Cipher initialized: " + cipher.getAlgorithm());
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
}