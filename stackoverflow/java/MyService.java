import org.springframework.cache.annotation.Cacheable;

public class MyService {

    @Cacheable("myCache")
    public String getInformation(String userId) {
        // ... method implementation ...
        return "information for user " + userId;
    }
}