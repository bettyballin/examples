import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String command = "curl http://stackoverflow.com/questions/27544456/spring-security-cannot-find-class-daoauthenticationprovider";
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean printLine = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("class=\"org.springframework.security.authentication.dao.DaoAuthenticationProvider")) {
                    printLine = true;
                }
                if (printLine) {
                    System.out.println(line);
                    if (line.contains("</")) { // End of context
                        printLine = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}