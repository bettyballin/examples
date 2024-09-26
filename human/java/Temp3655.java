import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Temp3655 {
    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("powershell.exe", "scripts/sign-gui.ps1", "-input", "target/library.jar", "-output", "target/signature.asc");
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("Exited with error code : " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}