import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.mockito.Mock;

public class Temp865 {

    @Mock
    private Object dao; // Replace 'Object' with actual DAO type

    private Object svc; // Replace 'Object' with actual Service type

    public static void main(String[] args) {
        Temp865 temp = new Temp865();
        temp.initMock();
    }

    public void initMock() {
        MockitoAnnotations.openMocks(this);
        // Set mock DAO to service
        ReflectionTestUtils.setField(svc, "dao", dao);
    }
}