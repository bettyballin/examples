import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Temp1911 {
    public static void main(String[] args) {
        executeCommand("openssl rsa -pubin -in pub.pem -out pub.der -outform der");
        executeCommand("openssl pkey -pubin -in pub.pem -out pub.der -outform der");
    }

    private static void executeCommand(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}