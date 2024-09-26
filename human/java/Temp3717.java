import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Temp3717 {
    public static void main(String[] args) {
        String existingKeyPath = "<path to existing private PKCS#8 key>";
        String generatedKeyPath = "<path to X.509 key to be generated>";

        // Construct the command
        String command = String.format("ssh-keygen -f \"%s\" -i -m PKCS8 -e > \"%s\"", existingKeyPath, generatedKeyPath);

        try {
            // Execute the command
            Process process = Runtime.getRuntime().exec(new String[] { "bash", "-c", command });
            process.waitFor();

            // Read the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Read any errors
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}