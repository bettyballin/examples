import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Temp3441 {
    public static void main(String[] args) {
        try {
            String[] command = {
                "curl", "-k",
                "--user", "Default\\admin:password",
                "--header", "Content-Type: application/json",
                "--data", "{\"method\":\"Search_Inventory_Items\", \"params\": {\"type\":\"OTP Token\"}, \"id\":0, \"jsonrpc\":\"2.0\"}",
                "https://localhost/manag/"
            };
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}