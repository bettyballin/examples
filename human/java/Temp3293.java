import java.net.*;
import java.io.*;

public class Temp3293 {
    public static void main(String[] args) {
        try {
            // Specify the URL of the server
            URL url = new URL("http://localhost:8080");
            // Create a connection to the server
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            // Get the response content
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            // Print the response content
            System.out.println("Response Content: " + response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}