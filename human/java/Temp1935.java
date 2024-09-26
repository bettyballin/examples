import java.io.IOException;

public class Temp1935 {
    public static void main(String[] args) {
        try {
            Process process = new ProcessBuilder("openssl", "pkcs8", "-topk8", "-inform", "PEM", "-outform", "DER", "-in", "private_key.pem", "-out", "private_key.der", "-nocrypt").start();
            process.waitFor();
            System.out.println("OpenSSL command executed successfully.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}