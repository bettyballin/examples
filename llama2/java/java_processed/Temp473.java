import java.security.Security;
import com.sun.crypto.provider.SunJCE;

public class Temp473 {
    public static void main(String[] args) {
        Security.addProvider(new SunJCE());
        System.out.println("SunJCE provider added.");
    }
}