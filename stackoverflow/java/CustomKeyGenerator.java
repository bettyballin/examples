import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

import java.lang.reflect.Method;

public class CustomKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}

@Configuration
@EnableCaching
class CacheConfiguration {

    @Bean("customKeyGenerator")
    public KeyGenerator customKeyGenerator() {
        return new CustomKeyGenerator();
    }
}

class SomeService {
    @Cacheable(value = "resultCache", keyGenerator = "customKeyGenerator")
    public Result getResult() {
        // Method implementation
        return new Result();
    }
}

class Result {
    // Result class implementation
}