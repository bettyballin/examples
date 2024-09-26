import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        HttpClient httpclient = new DefaultHttpClient();
        
        // Note that the specified port 443 corresponds with the SSL service
        ((AbstractHttpClient) httpclient).getCredentialsProvider().setCredentials(
                new AuthScope("www.moneytrackin.com", 443),
                new UsernamePasswordCredentials("user", "password"));
        
        // Https page to access
        HttpGet httpget = new HttpGet("https://www.moneytrackin.com/api/rest/getBalance");
        HttpResponse response;
        
        try {
            response = httpclient.execute(httpget);
            
            System.out.println("State: " + response.getStatusLine().toString());
            HttpEntity entity = response.getEntity();
            
            if (entity != null) {
                InputStream instream = entity.getContent();
                String result = convertStreamToString(instream);
                System.out.println("Data: " + result);
                instream.close();
            }
            
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}