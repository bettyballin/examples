import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Temp2654 {
    public static void main(String[] args) {
        try {
            String command = "jarsigner -keystore <path to keystore> -storetype Luna -tsa http://timestamp.digicert.com <path to jar> <key label> -certchain <path to certchain> -J-cp -J<path to LunaProvider.jar>";
            Process process = Runtime.getRuntime().exec(command);
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }
            
            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}