import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp1211 {
    public static void main(String[] args) {
        Temp1211 temp = new Temp1211();
        temp.setup();
    }

    public void setup() {
        CustomTestSecurityContextHolder customTestSecurityContextHolder = new CustomTestSecurityContextHolder();

        // Set the strategy to MODE_GLOBAL
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_GLOBAL);

        SecurityContext context = customTestSecurityContextHolder.createEmptyContext();
        
        // Additional code to use the context if necessary
    }
}

class CustomTestSecurityContextHolder {
    public SecurityContext createEmptyContext() {
        return SecurityContextHolder.createEmptyContext();
    }
}