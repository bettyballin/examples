import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Service;

public class Temp1556 {
    public static void main(String[] args) {
        // This is where the application would start
    }
}

@Service
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class FileService {

    @PostAuthorize("hasPermission(returnObject, 'READ')")
    public FileObject readFileObject(String path) {
        // return the file object from DAO
        return new FileObject(path);
    }

    @PreAuthorize("hasPermission(#fileObj, 'WRITE')")
    public void writeFileObject(FileObject fileObj) {
        // write the file object, security check made at this point
    }
}

class FileObject {
    private String path;

    public FileObject(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}