import java.net.InetSocketAddress;
import java.net.Proxy;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Temp1681 {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient.Builder()
            .proxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("<your-meek-proxy>", <port>)))
            .build();

        Request request = new Request.Builder()
            .url("https://somewebsite.org/TheProject.html")
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


Note: You will need to replace `<your-meek-proxy>` and `<port>` with the appropriate values and ensure that the OkHttp library is included in your project dependencies.