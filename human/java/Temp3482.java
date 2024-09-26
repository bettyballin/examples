import org.springframework.security.test.context.support.WithMockUser;

public class Temp3482 {
    @WithMockUser(authorities = "ROLE_ADMIN")
    public static void main(String[] args) {
        System.out.println("Running with ROLE_ADMIN authority.");
    }
}