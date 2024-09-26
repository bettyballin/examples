import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

public class Temp3403 {
    public static void main(String[] args) {
        // You would typically run this within a Spring application context
        // This is just a placeholder for an example
    }
}

@Service
class ResultService {

    @Cacheable(value = "resultCache", key = "#authentication.name")
    public Result getResult(Authentication authentication) {
        // Implementation here
        return new Result();
    }
}

class Result {
    // Define the properties and methods for the Result class
}