import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
public class Temp1753 {

    public static void main(String[] args) {
        Temp1753 temp = new Temp1753();
        temp.testCreateAdmin();
        temp.testWithRoleUser();
    }

    @Test
    @WithMockUser("admin")
    public void testCreateAdmin() {
        System.out.println("Running testCreateAdmin with admin user");
        // Test code here
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testWithRoleUser() {
        System.out.println("Running testWithRoleUser with user role");
        // Test code here
    }
}