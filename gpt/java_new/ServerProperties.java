import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.PortMapper;
import org.springframework.security.web.PortMapperImpl;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "server")
public class ServerProperties {
    private int httpPort;
    private int httpsPort;

    public int getHttpPort() {
        return httpPort;
    }

    public void setHttpPort(int httpPort) {
        this.httpPort = httpPort;
    }

    public int getHttpsPort() {
        return httpsPort;
    }

    public void setHttpsPort(int httpsPort) {
        this.httpsPort = httpsPort;
    }
}

@Bean
public PortMapper portMapper(ServerProperties serverProperties) {
    PortMapperImpl portMapper = new PortMapperImpl();
    Map<String, String> portMappings = new HashMap<>();
    portMappings.put(String.valueOf(serverProperties.getHttpPort()), String.valueOf(serverProperties.getHttpsPort()));
    portMapper.setPortMappings(portMappings);
    return portMapper;
}