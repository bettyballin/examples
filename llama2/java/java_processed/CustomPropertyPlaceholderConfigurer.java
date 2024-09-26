import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Properties;

@Configuration
public class CustomPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    @Override
    protected void convertProperties(Properties props) {
        // Replace placeholders with environment variable values
        props.put("myapp.home-org", System.getenv("HOME_ORG_ID"));
        super.convertProperties(props);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}