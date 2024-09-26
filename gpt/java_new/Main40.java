import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Main40 {
    public static void main(String[] args) {
        try {
            String challenge = "yourChallengeStringHere";
            byte[] challengeBytes = challenge.getBytes("UTF-8");
            
            String keyString = "yourKeyStringHere";
            Key aesKey = new SecretKeySpec(keyString.getBytes("UTF-8"), "AES");
            Cipher aes = Cipher.getInstance("AES");
            aes.init(Cipher.ENCRYPT_MODE, aesKey);
            
            String guid = new String(aes.doFinal(challengeBytes), "UTF-8");
            System.out.println(guid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}