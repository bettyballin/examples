import static org.mockito.Mockito.*;

public class Temp1066 {

    public static void main(String[] args) {
        // Initialize the mock object
        AssessmentService mockAssessmentService = mock(AssessmentService.class);
        Assessment yourMockObject = new Assessment();

        // Define the behavior of the mock object
        when(mockAssessmentService.getById(anyInt())).thenReturn(yourMockObject);

        // Example usage
        Assessment assessment = mockAssessmentService.getById(1);
        System.out.println(assessment);
    }
}

// Dummy classes to make the code executable
class AssessmentService {
    public Assessment getById(int id) {
        return new Assessment();
    }
}

class Assessment {
    @Override
    public String toString() {
        return "Mock Assessment Object";
    }
}