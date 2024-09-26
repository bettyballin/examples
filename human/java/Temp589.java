import java.net.MalformedURLException;
import java.net.URL;

public class Temp589 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com");
            if(url.getProtocol().equalsIgnoreCase("https")) {
                String newUrl = url.toString().replace("www.", "secure.");
                System.out.println(newUrl);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}