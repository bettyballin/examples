import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.Cipher;
import java.security.Security;

public class Temp839 {
    public static void main(String[] args) {
        try {
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding", "BC");
            System.out.println("Cipher created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}