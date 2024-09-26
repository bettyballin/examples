import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 1; i <= 3; i++) {
            String jarPath = "path/to/your/jarfile.jar";
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", jarPath, "data/config" + i + ".xml");
            pb.inheritIO().start();
        }
    }
}