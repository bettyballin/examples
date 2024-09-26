import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeResource {

    @Autowired
    private CoolServices coolServices;

    @PreAuthorize("hasPerm(@coolServices.getSuperCoolService().resolve(#attribute))")
    @GetMapping("/resource")
    public void resource(String attribute) {
        // Implement the resource logic here
    }
}

@Service
class CoolServices {
    public SuperCoolService getSuperCoolService() {
        return new SuperCoolService();
    }
}

class SuperCoolService {
    public String resolve(String attribute) {
        // Implement the resolve logic here
        return "resolvedValue";
    }
}