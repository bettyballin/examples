import java.security.Signature;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Temp1083 {
    public static void main(String[] args) {
        try {
            Signature instance = Signature.getInstance("SHA256withRSA/PSS", "BC");
            System.out.println("Signature instance created successfully");
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
}