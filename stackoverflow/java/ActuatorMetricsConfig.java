import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.micrometer.prometheus.PrometheusMeterRegistry;

@Configuration
public class ActuatorMetricsConfig {

    @Bean
    InitializingBean forcePrometheusPostProcessor(BeanPostProcessor meterRegistryPostProcessor, PrometheusMeterRegistry registry) {
        return () -> {
            meterRegistryPostProcessor.postProcessAfterInitialization(registry, "prometheusMeterRegistry");
            return null;
        };
    }
}