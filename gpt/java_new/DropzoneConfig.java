import com.somepackage.CsrfTokenProvider; // Placeholder for actual import

public class DropzoneConfig {
    private int parallelUploads = 1;
    private int maxFileSize = 30;
    private String url = "/api/companies/upload/logo";
    private boolean autoProcessQueue = false; // Prevent automatic upload

    private CsrfTokenProvider csrfTokenProvider; // Assuming an interface for providing CSRF tokens

    public DropzoneConfig(CsrfTokenProvider csrfTokenProvider) {
        this.csrfTokenProvider = csrfTokenProvider;
    }

    public void init() {
        // Dropzone initialization logic here
        // Use csrfTokenProvider to get the CSRF token
        String csrfToken = csrfTokenProvider.provideToken();

        // Configure the Dropzone with the CSRF token and other necessary settings
        // ...
    }

    // Additional methods or configuration settings
}