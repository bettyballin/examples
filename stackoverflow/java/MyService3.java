import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;

public class MyService3 {
    private RestTemplate rest;
    private int port;

    public MyService3(RestTemplate rest, int port) {
        this.rest = rest;
        this.port = port;
    }

    public ResponseEntity<List> getEmployeeList() {
        ResponseEntity<List> response = rest.withBasicAuth("RealUser", "RealPassword")
                                            .getForEntity("http://localhost:" + port + "/employee", List.class);
        return response;
    }
}