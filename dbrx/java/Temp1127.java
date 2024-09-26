import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.client.utils.URIBuilder;
import java.net.URI;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp1127 {

    private static final String PRIVATE_KEY = "your_private_key";
    private static final String PUBLIC_KEY = "your_public_key";
    private static final String POST_URL_STRING = "your_post_url";
    private static final String KEY_HEADER = "your_key_header";
    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String ENCODING = "UTF-8";

    public static void main(String[] args) {

        try {
            URI uri = new URI("your_uri_here");
            String sigToEncrypt = "your_sig_to_encrypt";

            String signature = generateHMACSHA256Signature(PRIVATE_KEY, sigToEncrypt);

            URIBuilder builder = new URIBuilder(uri);
            builder.setParameter("signature", signature);
            URI uriSigned = builder.build();

            String toSend = uriSigned.toString().substring(uriSigned.toString().indexOf('?') + 1);

            CloseableHttpClient client = HttpClients.custom()
                    .setSSLHostnameVerifier(new NoopHostnameVerifier())
                    .build();

            HttpPost httppost = new HttpPost(POST_URL_STRING);
            httppost.setHeader(KEY_HEADER, PUBLIC_KEY);
            httppost.setHeader("Content-Type", CONTENT_TYPE + "; charset=" + ENCODING);

            StringEntity se = new StringEntity(toSend);
            httppost.setEntity(se);

            HttpResponse response = client.execute(httppost);

            String result = parseServerResponse(response);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the http client to prevent resource leak
            CloseableHttpClient client = HttpClients.createDefault();
            try {
                client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String generateHMACSHA256Signature(String key, String data) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        return Base64.getEncoder().encodeToString(sha256_HMAC.doFinal(data.getBytes()));
    }

    private static String parseServerResponse(HttpResponse response) throws Exception {
        // Implement this method according to your server response structure
        // For example, you might read the response entity and convert it to a string
        return "response_parsed"; // Placeholder
    }
}