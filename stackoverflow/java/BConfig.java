import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BConfig {  

    private final AConfig aConfig;

    @Autowired
    public BConfig(AConfig aConfig) {
        this.aConfig = aConfig;
    }

    @Bean
    public B b() {
        B b = new B();
        b.setA(aConfig.a());
        return b;
    }
}