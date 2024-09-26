import javax.annotation.security.RolesAllowed;

public class FileDownloadService {
    @RolesAllowed("StandardRole")
    public void downloadFile(String fileId) {
        // Code to download the file with the given fileId
    }
}