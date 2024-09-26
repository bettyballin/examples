import javax.crypto.Cipher;

public class Main66 {
    public static void main(String[] args) {
        try {
            final Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}