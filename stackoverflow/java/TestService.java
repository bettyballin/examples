import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;

public class TestService {
    
    private TestRepository testRepository;

    // Constructor, getters, and setters for testRepository can be added here.

    public void update(List<Test> tests) {
        for (Test test : tests) {
            update(test);
        }
    }

    @PreAuthorize("hasPermission(#test, 'write') or hasAnyRole('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    public void update(Test test) {
        testRepository.save(test);
        updateDeviceAcl(test);
    }
    
    private void updateDeviceAcl(Test test) {
        // Implementation for updating the device ACL
    }
}

class Test {
    // Implementation of Test class
}

interface TestRepository {
    void save(Test test);
    // Other methods can be added here.
}