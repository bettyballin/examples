import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp3716 {
    public static void main(String[] args) {
        String command = "ssh-keygen -f <path to existing public OpenSSH key> -e -m pkcs8 > <path to X.509 key to be generated>";

        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}