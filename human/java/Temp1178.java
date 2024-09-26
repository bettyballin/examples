import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Temp1178 {
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("keytool -list -keystore cacerts -storepass changeit");
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