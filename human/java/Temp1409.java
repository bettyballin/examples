public class Temp1409 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

class ClientDetailsServiceConfigurer {
    public Clients inMemory() {
        return new Clients();
    }
}

class Clients {
    public Clients withClient(String client) {
        System.out.println("withClient: " + client);
        return this;
    }

    public Clients scopes(String scope) {
        System.out.println("scopes: " + scope);
        return this;
    }

    public Clients resourceIds(String resourceId) {
        System.out.println("resourceIds: " + resourceId);
        return this;
    }

    public Clients secret(String secret) {
        System.out.println("secret: " + secret);
        return this;
    }

    public Clients authorizedGrantTypes(String... grantTypes) {
        System.out.println("authorizedGrantTypes: " + String.join(", ", grantTypes));
        return this;
    }

    public Clients and() {
        return this;
    }
}

class MyCustomConfig {
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("resource-serv")
                .scopes("read")
                .resourceIds("my-resource")
                .secret("secret123")
                .and()
                .withClient("app")
                .authorizedGrantTypes("client_credentials", "password", "refresh_token")
                .scopes("read")
                .resourceIds("my-resource")
                .secret("appclientsecret");
    }
}