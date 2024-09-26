import java.security.NoSuchAlgorithmException;
import java.security.Signature;

public class Temp544 {
    public static void main(String[] args) {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA", "SunMSCAPI");
            // ...

            Signature signature1 = Signature.getInstance("SHA256withRSA", "SunMSCAPI");

        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
}