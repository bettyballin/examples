import javax.crypto.Cipher;

public class Main76 {
    public static void main(String[] args) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            // Use the cipher here as needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}