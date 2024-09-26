import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class MyServiceImpl implements MyService {

    // Your injected dependencies and other methods...

    @Override
    @Cacheable(value = "myCache", key = "#root.caches[0].name + ':' + T(org.springframework.security.core.context.SecurityContextHolder).getContext().getAuthentication().getName()")
    public String getInformation() {
        // This method now uses the authenticated user's name as the cache key.
        return "something";
    }
}