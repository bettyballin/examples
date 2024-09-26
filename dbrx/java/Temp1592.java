import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;

public class Temp1592 {
    public static void main(String[] args) {
        Temp1592 temp = new Temp1592();
        temp.itShouldCreateNewPerson();
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void itShouldCreateNewPerson() {
        // ...
        System.out.println("Test executed with ADMIN role.");
    }
}