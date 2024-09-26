import javax.crypto.Cipher;

public class CipherExample {
    public static void main(String[] args) {
        try {
            final Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            // Cipher usage goes here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}