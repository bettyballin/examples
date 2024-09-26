import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class Temp439 {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException {
        Temp439 temp = new Temp439();
        System.out.println(temp.isUnlimitedKeyStrength());
    }

    public boolean isUnlimitedKeyStrength() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getMaxAllowedKeyLength("AES") == Integer.MAX_VALUE;
    }
}