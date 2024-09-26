import javax.crypto.Cipher;

public class Main {
    public static void main(String[] args) {
        try {
            Cipher cip = Cipher.getInstance("DES", "SunJCE");
            // Additional code to use the Cipher object
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}