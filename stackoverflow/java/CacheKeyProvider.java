import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.cache.annotation.Cacheable;

@Component
public class CacheKeyProvider {

    public String getUsernameKey() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}

class SomeService {

    private final CacheKeyProvider cacheKeyProvider;

    public SomeService(CacheKeyProvider cacheKeyProvider) {
        this.cacheKeyProvider = cacheKeyProvider;
    }

    @Cacheable(value = "resultCache", key = "#root.target.cacheKeyProvider.getUsernameKey()")
    public Result getResult() {
        // method implementation goes here
        return new Result();
    }
}

class Result {
    // Result class implementation
}