import java.io.IOException;

public class Temp250 {
    public static void main(String[] args) {
        try {
            Process process = new ProcessBuilder("ssh", "-i", "path/to/private/key", "user@host", "/path/to/script").start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}