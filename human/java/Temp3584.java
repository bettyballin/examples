import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;

public class Temp3584 {
    @MockBean(name = "SecurityService")
    private SecurityService securityService;

    public static void main(String[] args) {
        Temp3584 temp = new Temp3584();
        System.out.println("MockBean: " + temp.securityService);
    }
}

@Service
class SecurityService {
    // SecurityService implementation
}