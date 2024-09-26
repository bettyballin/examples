import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp3715 {
    public static void main(String[] args) {
        try {
            String command = "ssh-keygen -p -N \"\" -m pkcs8 -f \"<path to existing private OpenSSH key>\""; // replace <path to existing private OpenSSH key> with actual path
            Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }

            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}