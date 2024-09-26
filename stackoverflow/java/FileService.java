import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

public class FileService {

    @PostAuthorize("hasPermission(returnObject, 'READ')")
    public FileObject readFileObject(String path) {
        // return the file object from DAO
        return null; // Placeholder for actual implementation
    }

    @PreAuthorize("hasPermission(#fileObj, 'WRITE')")
    public void writeFileObject(FileObject fileObj) {
        // write the file object, security check made at this point
        // Placeholder for actual implementation
    }
}

class FileObject {
    // Placeholder for the actual FileObject implementation
}