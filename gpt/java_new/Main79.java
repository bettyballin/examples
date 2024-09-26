import java.io.InputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class Main79 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://example.com/fileOfInterest");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        InputStream iStream = connection.getInputStream();
        // Remember to close the InputStream after use
        iStream.close();
    }
}