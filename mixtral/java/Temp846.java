import org.springframework.security.test.context.support.WithMockUser;
import org.junit.jupiter.api.Test;

public class Temp846 {

    @Test
    @WithMockUser(username = "testuser", roles = {"USER", "ADMIN"})
    public void testMySecuredMethod() {
        // Your existing code here
        System.out.println("Test executed with mock user");
    }

    public static void main(String[] args) {
        Temp846 temp = new Temp846();
        temp.testMySecuredMethod();
    }
}