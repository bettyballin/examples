// This is a Java snippet using Spring's ReflectionTestUtils and Mockito.
// However, without proper context, classes, and imports, it cannot be refactored to compile on its own.
// This snippet seems to be part of a test method in a larger codebase.
// To make it compile, we must assume the surrounding context and necessary imports.

// Assuming necessary imports
import org.springframework.test.util.ReflectionTestUtils;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;
import java.util.Optional;

// Assuming necessary context and classes are defined elsewhere:
// - TestUtil.unwrapService() is assumed to be a valid static method.
// - assessmentAuthorizationService is assumed to be a declared and initialized variable.
// - mockAssessmentService is assumed to be a declared and initialized mock object.
// - Assessment is assumed to be a class.
// - AssessmentService is assumed to be an interface with a method getById(Long id).

public class SomeTestClass2 {
    // Assuming these member variables are declared somewhere in the test class
    private YourServiceType assessmentAuthorizationService;
    private AssessmentService mockAssessmentService;
    private Assessment assessment;

    public void someTestMethod() {
        ReflectionTestUtils.setField(TestUtil.unwrapService(assessmentAuthorizationService),
                                     "assessmentService", mockAssessmentService);
        when(mockAssessmentService.getById(eq(2L))).thenReturn(Optional.of(assessment));
    }
}