import java.util.HashMap;
import java.util.Map;

public class Temp3651 {
    public static void main(String[] args) {
        String username = "notAnEmail@gmail.com";
        String password = "notAPassword";

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("email", username);
        requestBody.put("password", password);

        String sessionUrl = "http://example.com/login"; // Replace with actual URL

        // This code requires a library to handle HTTP requests such as Apache HttpClient or OkHttp
        // Here is an example using OkHttp
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();

        okhttp3.MediaType JSON = okhttp3.MediaType.get("application/json; charset=utf-8");
        okhttp3.RequestBody body = okhttp3.RequestBody.create(JSON, new org.json.JSONObject(requestBody).toString());

        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(sessionUrl)
                .post(body)
                .build();

        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, java.io.IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws java.io.IOException {
                if (response.isSuccessful()) {
                    System.out.println(response.body().string());
                } else {
                    System.out.println("Request failed: " + response.message());
                }
            }
        });
    }
}