import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import okhttp3.*;

public class Temp766 {

    public static void main(String[] args) {
        // Example usage
        File file = new File("path/to/your/file.jpg");
        String shareToken = "your_share_token";
        
        Temp766 temp766 = new Temp766();
        temp766.uploadFile(file, shareToken);
    }

    public void uploadFile(File file, String shareToken) {
        OkHttpClient client = new OkHttpClient();

        // Create the form body
        MultipartBody.Builder formBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        formBuilder.addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("application/octet-stream"), file));
        formBuilder.addFormDataPart("shareToken", shareToken);

        RequestBody requestBody = formBuilder.build();

        // Create the request
        Request request = new Request.Builder()
                .url("http://yourserver.com/api/companies/upload/logo")  // Replace with your actual URL
                .post(requestBody)
                .build();

        // Execute the request
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            // Handle the response
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}