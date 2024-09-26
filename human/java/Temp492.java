import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.annotation.EnableCaching;

@Configuration
@EnableCaching
public class Temp492 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Temp492.class);
        MyService service = context.getBean(MyService.class);
        System.out.println(service.getInformation("user123"));
        context.close();
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("myCache");
    }

    public static class MyService {
        @Cacheable("myCache")
        public String getInformation(String userId) {
            return "Information for " + userId;
        }
    }
}