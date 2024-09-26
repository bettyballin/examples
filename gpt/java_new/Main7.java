import java.io.IOException;

public class Main7 {
    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("sh", "-c", "ulimit -c 0");
            processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}