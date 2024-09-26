import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CacheKeyProvider {

    public String getUsernameKey() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}

@Service
public class ResultService {

    private final CacheKeyProvider cacheKeyProvider;

    public ResultService(CacheKeyProvider cacheKeyProvider) {
        this.cacheKeyProvider = cacheKeyProvider;
    }

    @Cacheable(value = "resultCache", key = "#cacheKeyProvider.getUsernameKey()")
    public Result getResult() {
        // Your logic to get the result
        return new Result();
    }
}

class Result {
    // Your Result class implementation
}