import static org.mockito.Mockito.*;

public class Temp2520 {
    public static void main(String[] args) {
        SecurityService securityService = mock(SecurityService.class);
        when(securityService.hasAccessToUser("userId")).thenReturn(true);
        System.out.println(securityService.hasAccessToUser("userId")); // This should print true
    }
}

interface SecurityService {
    boolean hasAccessToUser(String userId);
}