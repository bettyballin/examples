import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Temp32 {
    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                "openssl", "pkcs8", "-topk8", "-nocrypt", "-in", "private.pem", "-outform", "der", "-out", "private.der"
            );
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}