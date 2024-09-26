import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.utils.URIBuilder;

public class Temp2594 {
    public static void main(String[] args) {
        try {
            // Example URI and signature, replace with actual values
            String uri = "http://example.com/resource";
            String signature = "sampleSignature";

            // Build signed URI w/ encrypted signature (need only for the 'toSend' String)
            URI uriSigned = new URIBuilder(uri).setParameter("signature", signature).build();

            // This is what we actually POST, includes the encrypted signature. Seems hack-y.
            String toSend = uriSigned.toString().substring(uriSigned.toString().indexOf('?') + 1);

            // Print the 'toSend' string for demonstration purposes
            System.out.println(toSend);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}