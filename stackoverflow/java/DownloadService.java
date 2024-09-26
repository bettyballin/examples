import javax.annotation.security.RolesAllowed;

public class DownloadService {

    @RolesAllowed("SuperUser")
    public void downloadFile(String specialPathPattern, String fileId) {
        // Implementation for downloading the file from the given path
    }
}