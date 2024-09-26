import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;

public class SomeService2 {

    @Cacheable(value = "resultCache", key = "#authentication.name")
    public Result getResult(Authentication authentication) {
        // Method implementation goes here
        return new Result(); // Placeholder for the actual result
    }
    
    // Assuming a Result class exists
    class Result {
        // Result fields and methods
    }
}