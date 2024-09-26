import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class MyConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PortMapper myPortMapper() {
        return new CustomPortMapper();
    }

    @Bean
    public static PortMapperConfigurer portMapperConfigurer(PortMapper portMapper) {
        return new PortMapperConfigurer(portMapper);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.portMapper().portMapper(myPortMapper());
    }
}

class CustomPortMapper implements PortMapper {
    @Override
    public Integer lookupHttpPort(Integer httpsPort) {
        // Custom implementation here
        return 8080;
    }

    @Override
    public Integer lookupHttpsPort(Integer httpPort) {
        // Custom implementation here
        return 8443;
    }
}

class PortMapperConfigurer {
    private final PortMapper portMapper;

    public PortMapperConfigurer(PortMapper portMapper) {
        this.portMapper = portMapper;
    }

    public PortMapper getPortMapper() {
        return portMapper;
    }
}

interface PortMapper {
    Integer lookupHttpPort(Integer httpsPort);
    Integer lookupHttpsPort(Integer httpPort);
}