import java.util.function.Consumer;

public class Temp2826 {
    public static void main(String[] args) {
        // Example usage of HttpSecurityConfig interface
        HttpSecurityConfig config = new HttpSecurityConfig() {
            @Override
            public Consumer<ServerHttpSecurity> configuration() {
                return serverHttpSecurity -> {
                    // Configuration logic here
                };
            }
        };
        
        // Dummy ServerHttpSecurity class for demonstration purposes
        class ServerHttpSecurity {
            // Add methods and properties as required
        }
        
        // Apply the configuration
        ServerHttpSecurity serverHttpSecurity = new ServerHttpSecurity();
        config.configuration().accept(serverHttpSecurity);
    }
    
    public interface HttpSecurityConfig {
        Consumer<ServerHttpSecurity> configuration();
    }
}