import org.springframework.boot.test.mock.mockito.MockBean;
import your.package.SecurityService; // replace with the actual package of SecurityService

public class YourTestClass3 {

    @MockBean(name="SecurityService")
    private SecurityService securityService;

    // other class members and methods
}