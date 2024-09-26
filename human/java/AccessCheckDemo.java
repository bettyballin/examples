import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AccessCheckDemo {
    public static void main(String[] args) throws IOException {
        String[] files = {"c:/foo", "c:/bar"};
        for (String file : files) {
            Path path = Paths.get(file);
            System.out.println("check " + path);
            System.out.println("file      Files.isWritable: "
                    + Files.isWritable(path));
            System.out.println("directory Files.isWritable: "
                    + Files.isWritable(path.getParent()));
            System.out.println();
        }
    }
}