import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp1912 {
    public static void main(String[] args) {
        try {
            // Execute OpenSSL commands from Java
            executeCommand("openssl rsa -in id_rsa -pubout -out pub.pem"); // default PEM
            executeCommand("openssl rsa -in id_rsa -pubout -out pub.der -outform der"); // DER
            executeCommand("openssl pkey -in id_rsa -pubout -out pub.pem"); // default PEM, 1.0.0 up
            executeCommand("openssl pkey -in id_rsa -pubout -out pub.der -outform der"); // DER, 1.0.0
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void executeCommand(String command) throws IOException {
        Process process = Runtime.getRuntime().exec(command);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}