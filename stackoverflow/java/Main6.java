import java.security.KeyStore;
import java.security.Security;

public class Main6 {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new sun.security.mscapi.SunMSCAPI());
        KeyStore msCertStore = KeyStore.getInstance("Windows-MY", "SunMSCAPI");
        msCertStore.load(null, null);
    }
}