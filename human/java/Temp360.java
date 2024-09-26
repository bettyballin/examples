import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

class StateCache implements InitializingBean {
    private int maxSize;

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

    public void init() {
        System.out.println("StateCache initialized with maxSize = " + maxSize);
    }
}

@Configuration
class AppConfig {

    @Bean
    @Scope("prototype")
    public StateCache cache(@Value("${cache.maxSize:200}") int maxSize) {
        StateCache stateCache = new StateCache();
        stateCache.setMaxSize(maxSize);
        return stateCache;
    }
}

public class Main {
    public static void main(String[] args) {
        org.springframework.context.annotation.AnnotationConfigApplicationContext context =
                new org.springframework.context.annotation.AnnotationConfigApplicationContext(AppConfig.class);

        StateCache cache = context.getBean(StateCache.class);
        context.close();
    }
}