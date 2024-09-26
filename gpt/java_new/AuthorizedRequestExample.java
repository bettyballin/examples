import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class AuthorizedRequestExample {

    private static final String JWT_TOKEN_KEY = "jwtToken";

    // Store the token in local storage for later use
    // Assuming the token is obtained after login, for example: String token = response.getToken();
    public void storeToken(String token) {
        // For demonstration purposes, we'll use a simple key-value pair.
        // In a real application, you should use a more secure storage method.
        Preferences.userRoot().put(JWT_TOKEN_KEY, token);
    }

    // When making future requests, retrieve the token and include it in the header
    public void makeAuthorizedRequest(String endpoint, String method, String jsonData,
                                      ActionListener successCallback, ActionListener errorCallback) {
        try {
            URL url = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            // Retrieve the token from local storage
            String token = Preferences.userRoot().get(JWT_TOKEN_KEY, null);
            if (token != null) {
                connection.setRequestProperty("Authorization", "Bearer " + token);
            }

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonData.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Handle success
                SwingUtilities.invokeLater(successCallback);
            } else {
                // Handle error
                SwingUtilities.invokeLater(errorCallback);
            }
        } catch (IOException e) {
            SwingUtilities.invokeLater(errorCallback);
        }
    }

    // Dummy ActionListener implementations for success and error
    public static void main(String[] args) {
        AuthorizedRequestExample example = new AuthorizedRequestExample();

        // Dummy token
        example.storeToken("your_jwt_token_here");

        // Dummy callbacks
        ActionListener successCallback = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Request successful!");
            }
        }