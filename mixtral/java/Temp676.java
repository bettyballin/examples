public class Temp676 {
    public static void main(String[] args) {
        // This is a placeholder main method
        System.out.println("Temp676 main method executed");
    }

    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient("app")
            .authorizedGrantTypes("client_credentials", "password", "refresh_token")
            .scopes("read")
            .resourceIds("my-resource")
            .secret("{noop}appclientsecret");
    }
}

// Dummy ClientDetailsServiceConfigurer class for demonstration purpose
class ClientDetailsServiceConfigurer {
    public InMemoryClientDetailsServiceConfigurer inMemory() {
        return new InMemoryClientDetailsServiceConfigurer();
    }
}

// Dummy InMemoryClientDetailsServiceConfigurer class for demonstration purpose
class InMemoryClientDetailsServiceConfigurer {
    public InMemoryClientDetailsServiceConfigurer withClient(String client) {
        System.out.println("Client: " + client);
        return this;
    }

    public InMemoryClientDetailsServiceConfigurer authorizedGrantTypes(String... grantTypes) {
        System.out.println("Grant Types: " + String.join(", ", grantTypes));
        return this;
    }

    public InMemoryClientDetailsServiceConfigurer scopes(String... scopes) {
        System.out.println("Scopes: " + String.join(", ", scopes));
        return this;
    }

    public InMemoryClientDetailsServiceConfigurer resourceIds(String... resourceIds) {
        System.out.println("Resource IDs: " + String.join(", ", resourceIds));
        return this;
    }

    public InMemoryClientDetailsServiceConfigurer secret(String secret) {
        System.out.println("Secret: " + secret);
        return this;
    }
}