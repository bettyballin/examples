import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CoolServiceProxy implements CoolService {

    private final CoolService coolService;

    @Autowired
    public CoolServiceProxy(List<CoolService> services, Environment env) {
        String[] activeProfiles = env.getActiveProfiles();
        this.coolService = services.stream()
            .filter(service -> Arrays.asList(activeProfiles).contains("super") && service instanceof SuperCoolService
                    || Arrays.asList(activeProfiles).contains("regular") && service instanceof RegularCoolService)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("No matching service found for active profiles"));
    }

    // Implement CoolService methods by delegating to the selected coolService
    // Example:
    // @Override
    // public void coolMethod() {
    //     coolService.coolMethod();
    // }
}