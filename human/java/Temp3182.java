import java.util.HashMap;
import java.util.Map;

public class Temp3182 {
    public static void main(String[] args) {
        Map<String, String> error = new HashMap<>();
        
        String condition = "Forbidden"; // This simulates the switch condition
        
        switch (condition) {
            case "Forbidden":
                if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().equals("[ROLE_ANONYMOUS]"))
                    error.put("error", "You have to log in to see this content");
                else
                    error.put("error", "It is only for admins");
                break;
            default:
                error.put("error", "Unknown error");
                break;
        }

        // Output the error message to see the results
        System.out.println(error.get("error"));
    }
}

// Mock classes to simulate SecurityContextHolder and Authentication
class SecurityContextHolder {
    public static SecurityContext getContext() {
        return new SecurityContext();
    }
}

class SecurityContext {
    public Authentication getAuthentication() {
        return new Authentication();
    }
}

class Authentication {
    public String getAuthorities() {
        return "[ROLE_ANONYMOUS]";
    }
}