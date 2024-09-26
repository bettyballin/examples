import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class YourTestClass {

    @Autowired
    private AssessmentAuthorizaionServiceImpl assessmentAuthService;

    // This will replace any existing bean of type `AssessmentService` with the mock
    @MockBean
    private AssessmentService mockAssessmentService;

    @Test
    public void testSomething() {
        // your test code here
    }

}