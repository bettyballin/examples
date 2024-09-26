import java.io.UnsupportedEncodingException;

public class Main57 {
    public static void main(String[] args) {
        String passphrase = "YourPassphrase";

        try {
            byte[] bytes = passphrase.getBytes("UTF-8");
            // Use the bytes as needed
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}