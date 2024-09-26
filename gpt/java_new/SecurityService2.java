import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecurityService2 {
    // Assume there's a PermissionService class that handles permissions
    @Autowired
    private PermissionService permissionService;

    public boolean hasPermission(Test test, String permission) {
        // Implement permission check logic here
        return true; // Placeholder return value
    }
}

public class Test {
    // Assume Test class has its properties and methods
}

@Service
public class TestService {

    @Autowired
    private SecurityService2 securityService;

    @Autowired
    private TestRepository testRepository;

    public void update(List<Test> tests) {
        List<Test> testsWithPermission = tests.stream()
                .filter(test -> securityService.hasPermission(test, "write"))
                .collect(Collectors.toList());

        testRepository.saveAll(testsWithPermission);
        testsWithPermission.forEach(this::updateDeviceAcl);
    }

    private void updateDeviceAcl(Test test) {
        // Implement ACL update logic here
    }
}

public interface TestRepository {
    // Assuming saveAll is already defined here
    void saveAll(List<Test> tests);
}