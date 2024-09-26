import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.MediaType;
import okhttp3.Response;
import java.io.IOException;

public class UpdateAppMetadata {
    public static void main(String[] args) {
        // Replace with your Auth0 domain and user ID
        String auth0Domain = "your-auth0-domain.com";
        String userId = "user_id";

        // Create an OkHttp client
        OkHttpClient client = new OkHttpClient();

        // Create JSON body for the request
        String json = "{ \"key1\": \"value1\", \"key2\": \"value2\" }";
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(json, JSON);

        // Construct the request to update app metadata
        Request request = new Request.Builder()
            .url(String.format("https://%s/api/v2/users/%s/app_metadata", auth0Domain, userId))
            .put(body)
            .addHeader("Authorization", "Bearer YOUR_ACCESS_TOKEN")
            .build();

        // Execute the request
        try (Response response = client.newCall(request).execute()) {
            // Check if the request was successful
            if (response.isSuccessful()) {
                System.out.println("Metadata updated successfully: " + response.body().string());
            } else {
                System.out.println("Failed to update metadata: " + response.code() + " " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}