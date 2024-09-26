import java.util.concurrent.TimeUnit;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;

public class Temp1865 {
    public static void main(String[] args) {
        String body = "Sample Body";
        ResponseEntity<String> response = ResponseEntity.ok()
                                                        .cacheControl(CacheControl.maxAge(600, TimeUnit.SECONDS))
                                                        .body(body);
        System.out.println(response);
    }
}