public class Temp564 {

    public static final String RESOURCE_ID = "bookmarks";

    public static void main(String[] args) {
        // Main method doesn't do anything in this example.
    }

    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // Ensure the resource ID is set for this client
        clients.inMemory()
            .withClient("android-" + RESOURCE_ID)
            .authorizedGrantTypes("password", "authorization_code", "refresh_token")
            .authorities("ROLE_USER")
            .scopes("write")
            .secret("123456")
            // Set the resource ID for this client
            .resourceIds(RESOURCE_ID);
    }

    // Mock class for ClientDetailsServiceConfigurer to make the code compilable
    public static class ClientDetailsServiceConfigurer {
        public InMemoryClientDetailsServiceConfigurer inMemory() {
            return new InMemoryClientDetailsServiceConfigurer();
        }

        public static class InMemoryClientDetailsServiceConfigurer {
            public InMemoryClientDetailsServiceConfigurer withClient(String clientId) {
                // Mock implementation
                return this;
            }

            public InMemoryClientDetailsServiceConfigurer authorizedGrantTypes(String... grantTypes) {
                // Mock implementation
                return this;
            }

            public InMemoryClientDetailsServiceConfigurer authorities(String... authorities) {
                // Mock implementation
                return this;
            }

            public InMemoryClientDetailsServiceConfigurer scopes(String... scopes) {
                // Mock implementation
                return this;
            }

            public InMemoryClientDetailsServiceConfigurer secret(String secret) {
                // Mock implementation
                return this;
            }

            public InMemoryClientDetailsServiceConfigurer resourceIds(String... resourceIds) {
                // Mock implementation
                return this;
            }
        }
    }
}