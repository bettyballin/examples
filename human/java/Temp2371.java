import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Temp2371 {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("/etc/flag"), Charset.defaultCharset());
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}