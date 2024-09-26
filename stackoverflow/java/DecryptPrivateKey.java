import java.io.IOException;

public class DecryptPrivateKey {
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("openssl rsa -in enc_private.key -out private.key -passin pass:passphrase_xyz");
            process.waitFor(); // Wait for the process to finish
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}