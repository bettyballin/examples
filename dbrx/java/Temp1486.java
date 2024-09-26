import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;

@RestController
public class Temp1486 {

    @Autowired
    private ComboVahedAmoozeshiRepository comboVahedAmoozeshiRepository;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/getFindByPersonId/{perId}")
    @PreAuthorize("@securityService.hasPermission(#perId)")
    public List getFindBySkhsIdCombo(@PathVariable Long perId) {
        return comboVahedAmoozeshiRepository.getFindBySkhsIdCombo(perId);
    }

    public static void main(String[] args) {
        SpringApplication.run(Temp1486.class, args);
    }
}

interface ComboVahedAmoozeshiRepository {
    List getFindBySkhsIdCombo(Long perId);
}

@Service
class SecurityService {
    public boolean hasPermission(Long perId) {
        // Implement security logic here
        return true;
    }
}

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
class Application {
}