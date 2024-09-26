import java.security.NoSuchAlgorithmException;
import java.security.Signature;

public class Temp335 {
    public static void main(String[] args) {
        try {
            Signature sig = Signature.getInstance("SHA256withRSA");
            System.out.println("Signature instance created successfully.");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}