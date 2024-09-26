import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        try {
            URI uri = new URI("https://my.domain.com/cas/login?service=https://my.protected-service.com/path/to/page/");
            System.out.println(uri.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}