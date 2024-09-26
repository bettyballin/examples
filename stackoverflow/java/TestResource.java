import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestResource {

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping(value = "/somePath", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object apiEndpoint() {
        return null;
    }

}