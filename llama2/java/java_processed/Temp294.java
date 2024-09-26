import org.apache.commons.io.FileUtils;
import java.io.File;

public class Temp294 {
    public static void main(String[] args) {
        try {
            File file = new File("test.txt");
            FileUtils.writeStringToFile(file, "Hello, World!", "UTF-8");
            String content = FileUtils.readFileToString(file, "UTF-8");
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}