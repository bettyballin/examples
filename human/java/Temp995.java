import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;

public class Temp995 {

    private TestRepository testRepository;

    public Temp995(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public static void main(String[] args) {
        // Example usage
    }

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
        // Implementation for updating device ACL
    }
}

interface TestRepository {
    void save(Test test);
}

class Test {
    // Test class implementation
}