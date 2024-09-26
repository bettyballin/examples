// This is not Java code, it is JavaScript/AngularJS code for making HTTP requests.
// To refactor it to Java, we would use a library like HttpClient from Apache or the java.net.HttpURLConnection class.

// Example refactoring using java.net.HttpURLConnection:

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestExample {
    private String csrfToken; // Token should be initialized properly
    private java.util.List<Record> records; // Assuming Record is a defined class and records is initialized

    public void deleteRecord(Record record) throws IOException {
        URL url = new URL("http://example.com/camera/list/" + record.getFilename()); // Use your actual URL
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setRequestMethod("DELETE");
        httpCon.setRequestProperty("X-CSRF-TOKEN", csrfToken);

        int responseCode = httpCon.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Assuming Record class has an overridden equals method
            records.remove(record);
        }
        httpCon.disconnect();
    }

    // getters and setters for csrfToken and records
}