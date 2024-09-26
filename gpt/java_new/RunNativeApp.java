import java.io.IOException;

public class RunNativeApp {
    
    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("C:\\Path\\To\\Your\\Executable.exe");
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}