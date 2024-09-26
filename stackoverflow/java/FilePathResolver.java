import java.io.File;
import java.io.IOException;

public class FilePathResolver {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/example/projects/sample/target", "../pom.xml").getCanonicalFile();
            System.out.println(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}