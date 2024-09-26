import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class FilePermissionChanger {
    public static void main(String[] args) {
        Path path = Paths.get("path/to/your/file.jpg");
        try {
            Set<PosixFilePermission> perms = PosixFilePermissions.fromString("r--r-----");
            Files.setPosixFilePermissions(path, perms);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}