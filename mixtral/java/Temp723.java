import java.nio.file.*;

public class Temp723 {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("/path/to/your/image");
            Files.setAttribute(path, "dos:readonly", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}