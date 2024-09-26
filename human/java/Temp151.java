import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileSystem;

public class Temp151 {

    private final File path;
    private final FileSystem fs;

    public Temp151(File path) {
        this.path = path;
        this.fs = FileSystems.getDefault();
    }

    public boolean canWrite() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkWrite(path.getPath());
        }
        try {
            return fs.provider().checkAccess(path.toPath(), FileSystem.AccessMode.WRITE);
        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        File file = new File("example.txt");
        Temp151 temp = new Temp151(file);
        System.out.println("Can write: " + temp.canWrite());
    }
}