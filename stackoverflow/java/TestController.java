import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PreAuthorize("hasAuthority('FinanceHead') or hasAuthority('FinanceAdmin') or hasAuthority('Finance3') or hasAuthority('Finance2') or hasAuthority('Finance1')")
    @GetMapping("/test")
    public ResponseEntity<String> test1() {
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }
}