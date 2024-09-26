import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Temp2346 {
    public static void main(String[] args) {
        try {
            // Command to run curl
            String[] command = {
                "curl",
                "-H", "Accept: application/json",
                "-u", "my-client-with-secret:secret",
                "-d", "grant_type=client_credentials",
                "http://localhost:8080/oauth/token"
            };

            // Run the command
            Process process = Runtime.getRuntime().exec(command);

            // Read the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}