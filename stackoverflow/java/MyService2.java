import org.springframework.cache.annotation.Cacheable;

public class MyService2 {

    @Cacheable(cacheNames = "myCache", condition = "@securityChecker.isSecured()")
    public Foo doIt(String key) {
        // ... method implementation ...
    }
}