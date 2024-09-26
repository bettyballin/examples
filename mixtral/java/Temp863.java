import java.io.IOException;
import java.util.concurrent.ExecutionException;
import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.Response;

public class Temp863 {
    private static final String LOGIN_URL = "example.com"; // Replace with actual URL

    public static void main(String[] args) {
        try {
            new Temp863().login("user@example.com", "password123");
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void login(String username, String password) throws IOException, InterruptedException, ExecutionException {
        try (AsyncHttpClient asyncHttpClient = Dsl.asyncHttpClient()) {
            asyncHttpClient
                .preparePost("https://" + LOGIN_URL)
                .addFormParam("email", username)
                .addFormParam("password", password)
                .execute(new AsyncCompletionHandler<Response>() {
                    @Override
                    public Response onCompleted(Response response) throws Exception {
                        // do something with the response object
                        System.out.println("Response: " + response.getResponseBody());
                        return response;
                    }

                    @Override
                    public void onThrowable(Throwable t) {
                        System.err.println("Error occurred: " + t);
                    }
                }).get(); // Wait for the response
        }
    }
}