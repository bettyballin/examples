import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Temp1055 {
    public static void main(String[] args) {
        try {
            String command = "curl -X POST -vu clientapp:123456 http://localhost:8080/oauth/token -H \"Accept: application/json\" -d \"password=spring&username=roy&grant_type=password&scope=read%20write&client_secret=123456&client_id=clientapp\"";
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}