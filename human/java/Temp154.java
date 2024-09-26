import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp154 {
    public static void main(String[] args) {
        try {
            // Command to be executed
            String command = "openssl pkcs8 -topk8 -nocrypt -outform DER -in D:\\host.key -out D:\\host.pk8";
            
            // Execute the command
            Process process = Runtime.getRuntime().exec(command);
            
            // Get the input stream (output from the command)
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}