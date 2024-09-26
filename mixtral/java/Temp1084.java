import java.security.Security;
import java.security.Signature;

public class Temp1084 {
    public static void main(String[] args) {
        try {
            String spongyProviderName = Security.getProviders()[Security.getProviders().length - 1].getName();
            Signature instance = Signature.getInstance("SHA256withRSAandMGF1", spongyProviderName);
            System.out.println("Signature instance created with provider: " + spongyProviderName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}