import javax.swing.JOptionPane;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PageLoader {
    public void loadPage(String elementId, String typeId) {
        JOptionPane.showMessageDialog(null, "loadPage/" + typeId);
        String loadUrl = "loadPage/" + typeId;

        // Assuming the implementation of loadContent method exists
        try {
            String content = loadContent(loadUrl);
            // Use the content as needed, e.g. update UI component
            // ...

            // Check for session expiration or authentication failure
            if (content.contains("401") || content.contains("302")) {
                // Session has expired or user is not authenticated
                // Redirect to the login page or handle accordingly
                // ...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String loadContent(String url) throws IOException {
        // Simulate loading content from URL, replace with actual implementation
        return new String(Files.readAllBytes(Paths.get(url)));
    }

    public static void main(String[] args) {
        PageLoader loader = new PageLoader();
        loader.loadPage("someElementId", "someTypeId");
    }
}