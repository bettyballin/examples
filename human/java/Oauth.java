import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public abstract class Oauth {

    public enum Method {
        Get,
        Post,
        Delete
    }

    protected String AccessToken;
    protected String AttributesBaseUrl;
    protected String Authorize;
    protected String CallbackUrl;
    protected String ConsumerKey;
    protected String ConsumerSecret;
    public String Provider;

    public String Token;

    public String AuthorizationLinkGet() {
        return String.format(
                "%s?client_id=%s&redirect_uri=%s&scope=publish_stream,email,user_education_history,user_location",
                Authorize, ConsumerKey, CallbackUrl);
    }

    public void AccessTokenGet(String authToken) throws IOException {
        Token = authToken;
        String accessTokenUrl = String.format("%s?client_id=%s&redirect_uri=%s&client_secret=%s&code=%s",
                AccessToken, ConsumerKey, CallbackUrl, ConsumerSecret, authToken);
        String response = WebRequest(Method.Get, accessTokenUrl, "");

        if (response.length() > 0) {
            Map<String, String> qs = parseQueryString(response);

            if (qs.get("access_token") != null) {
                Token = qs.get("access_token");
            }
        }
    }

    public String WebRequest(Method method, String url, String postData) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod(method.toString());
        connection.setDoOutput(true);
        connection.setConnectTimeout(20000);

        if (method == Method.Post) {
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = postData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
        }

        return WebResponseGet(connection);
    }

    public String WebResponseGet(HttpURLConnection connection) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        }
    }

    private Map<String, String> parseQueryString(String query) {
        Map<String, String> map = new HashMap<>();
        String[] params = query.split("&");
        for (String param : params) {
            String[] pair = param.split("=");
            if (pair.length > 1) {
                map.put(pair[0], pair[1]);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        // Test the implementation here
    }
}