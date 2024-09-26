import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;

@RestController
public class Temp1702 {
    public static void main(String[] args) {
        // Your main method code here
    }

    @PreAuthorize("#requestModel != null and @PermissionEvaluator.hasPermission(authentication, #requestModel, 'updateSync')")
    public ResponseEntity<Object> updateAndSaveMarketValueSelected(@RequestBody RequestModel requestModel) throws ParseException {
        // your code
        return ResponseEntity.ok("Success");
    }
}

class RequestModel {
    // Define your RequestModel fields and methods here
}

class PermissionEvaluator {
    public boolean hasPermission(Object authentication, Object targetDomainObject, String permission) {
        // Implement your permission logic here
        return true;
    }
}