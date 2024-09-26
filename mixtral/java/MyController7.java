import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @Value("${ifttt.service-key}")
    private String myIftttServiceKey;

    // This method checks if the provided IFTTT service key is valid
    public boolean hasValidIftttServiceKey(String serviceKey) {
        return myIftttServiceKey.equals(serviceKey);
    }

    // This endpoint will require the IFTTT service key
    @GetMapping("/myEndpoint")
    @PreAuthorize("@myController.hasValidIftttServiceKey(#root.this.myIftttServiceKey)")
    public ResponseEntity<String> myEndpoint() {
        return ResponseEntity.ok("Success");
    }

}