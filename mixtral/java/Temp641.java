import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.flywaydb.core.api.configuration.FlywayConfigurationCustomizer;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Temp641 {
    public static void main(String[] args) {
        // Main method can be left empty if no specific actions are needed on startup.
    }

    @Bean
    @FlywayDataSource
    public FlywayConfigurationCustomizer flywayConfig() {
        return new FlywayConfigurationCustomizer() {
            @Override
            public void customize(FluentConfiguration configuration) {
                configuration.baselineOnMigrate(true);
            }
        };
    }
}