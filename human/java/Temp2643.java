import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExecuteCommand {

    public static void main(String[] args) {
        try {
            String[] command = {
                "xcrun",
                "altool",
                "--eval-info",
                "a1b2c3d4e5-a1b2-a1b2-a1b2-a1b2c3d4e5f6",
                "-u",
                "john@domain.com"
            };
            
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            
            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}