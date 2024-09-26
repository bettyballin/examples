import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Temp1910 {
    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                "ssh-keygen", "-e", "-m", "PKCS8", "-f", "id_rsa.pub"
            );
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