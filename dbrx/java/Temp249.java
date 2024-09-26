import java.io.IOException;

public class Temp249 {
    public static void main(String[] args) {
        try {
            Process process = new ProcessBuilder("command", "arg1", "arg2").start();
            process.waitFor(); // added to handle the process
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}