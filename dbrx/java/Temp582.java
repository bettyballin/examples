import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Temp582 {
    public static void main(String[] args) {
        String urlToEncode = "/sam/pop/viewProfile?id=/<script>alert(123)</script>";
        String encodedUrl = URLEncoder.encode(urlToEncode, StandardCharsets.UTF_8.toString());
        System.out.println(encodedUrl);
    }
}