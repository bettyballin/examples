import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class Temp75 {
    public static void main(String[] args) {
        byte[] ivBytes = new byte[16];
        new SecureRandom().nextBytes(ivBytes);
        IvParameterSpec iv = new IvParameterSpec(ivBytes);
        System.out.println("IV: " + java.util.Arrays.toString(iv.getIV()));
    }
}