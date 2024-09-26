import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class Temp2324 {

    @Autowired
    private PrincipalExtractor principalExtractor;

    public static void main(String[] args) {
        // Spring Boot application entry point
        org.springframework.boot.SpringApplication.run(Temp2324.class, args);
    }

    @Cacheable(value = "resultCache", key = "#principalExtractor.getPrincipal()")
    public Result getResult() {
        return new Result();
    }
}

@Component
class PrincipalExtractor {
    public String getPrincipal() {
        return "principal";
    }
}

class Result {
    // Define fields and methods for Result class
}