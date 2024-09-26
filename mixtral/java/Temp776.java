import org.springframework.mock.web.MockHttpServletRequest;

public class Temp776 {
    public static void main(String[] args) {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addUserRole("ROLE_OWNER");

        // Now when isUserInRole() is called on 'request' it will return true for "ROLE_OWNER"
        boolean hasRoleOwner = request.isUserInRole("ROLE_OWNER");

        // Output the result to verify
        System.out.println("User has ROLE_OWNER: " + hasRoleOwner);
    }
}