import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import java.util.Arrays;

public class Temp1151 {
    public static void main(String[] args) {
        char[] password = getPassword();
        String strPassword = new String(password);
        Arrays.fill(password, '0');
        password = null;

        HttpPost postRequest = new HttpPost("https://example.com/api");
        postRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        JSONObject jsonBody = new JSONObject();
        jsonBody.put("username", "username");
        jsonBody.put("password", strPassword);

        StringEntity entity = new StringEntity(jsonBody.toString(), ContentType.APPLICATION_JSON);
        postRequest.setEntity(entity);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(postRequest)) {
            // Handle the response or error here.
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Overwrite/zero-out any sensitive data stored as Strings within those libraries if possible.
        strPassword = "00000";
    }

    // Mock method to simulate password input
    private static char[] getPassword() {
        return "secret".toCharArray();
    }
}