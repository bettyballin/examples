import java.security.*;
import java.security.spec.*;
import javax.crypto.spec.*;

public class Temp1086 {
    public static void main(String[] args) {
        try {
            PSSParameterSpec pssParams = new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1);
            System.out.println("PSSParameterSpec created successfully: " + pssParams);

            // You can now use pssParams with a Signature instance for signing or verification
            Signature signature = Signature.getInstance("RSASSA-PSS");
            signature.setParameter(pssParams);
            System.out.println("Signature instance created and parameters set successfully.");
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }
}