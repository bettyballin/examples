import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp3718 {
    public static void main(String[] args) {
        String command = "ssh-keygen -b 2048 -t rsa -N \"\" -m pkcs8 -f \"<path to private PKCS#8 key to be generated>\"";
        try {
            Process process = Runtime.getRuntime().exec(command);
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