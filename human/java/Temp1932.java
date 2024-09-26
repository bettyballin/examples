import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Temp1932 {
    public static void main(String[] args) {
        String serverAddress = "example.com"; // replace with actual server address
        int port = 443; // replace with actual port

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "openssl", "s_client", "-connect", serverAddress + ":" + port, "-showcerts"
            );
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