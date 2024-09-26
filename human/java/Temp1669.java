import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp1669 {

    public static void main(String[] args) {
        compile("org.thymeleaf.extras:thymeleaf-extras-springsecurity3");
    }

    public static void compile(String dependency) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("sh", "-c", "mvn dependency:get -Dartifact=" + dependency);

        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Dependency downloaded successfully.");
            } else {
                System.out.println("Error occurred while downloading dependency.");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}