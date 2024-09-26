import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;

public class YourServiceClass2 {

    @Cacheable(value = "resultCache", key = "#root.method.name + '_' + #principal")
    public Result getResult() {
        // Your method implementation
        return new Result(); // Replace with actual implementation
    }
    
    public String getPrincipal() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    
    // Assume Result is a class you have defined elsewhere
    public class Result {
        // Result class implementation
    }
}