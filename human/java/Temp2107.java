import org.springframework.security.oauth2.provider.ClientDetails;

public class Temp2107 {
    public static void main(String[] args) {
        // Example code using ClientDetails
        ClientDetails clientDetails = new ClientDetails() {
            @Override
            public String getClientId() {
                return "exampleClientId";
            }

            @Override
            public Set<String> getResourceIds() {
                return Collections.singleton("exampleResourceId");
            }

            @Override
            public boolean isSecretRequired() {
                return false;
            }

            @Override
            public String getClientSecret() {
                return null;
            }

            @Override
            public boolean isScoped() {
                return false;
            }

            @Override
            public Set<String> getScope() {
                return Collections.singleton("exampleScope");
            }

            @Override
            public Set<String> getAuthorizedGrantTypes() {
                return Collections.singleton("authorization_code");
            }

            @Override
            public Set<String> getRegisteredRedirectUri() {
                return Collections.singleton("http://example.com");
            }

            @Override
            public Collection<GrantedAuthority> getAuthorities() {
                return Collections.emptyList();
            }

            @Override
            public Integer getAccessTokenValiditySeconds() {
                return null;
            }

            @Override
            public Integer getRefreshTokenValiditySeconds() {
                return null;
            }

            @Override
            public Map<String, Object> getAdditionalInformation() {
                return Collections.emptyMap();
            }

            @Override
            public Set<String> getAutoApproveScopes() {
                return Collections.emptySet();
            }
        };

        System.out.println("Client ID: " + clientDetails.getClientId());
        System.out.println("Resource IDs: " + clientDetails.getResourceIds());
        System.out.println("Scope: " + clientDetails.getScope());
        System.out.println("Authorized Grant Types: " + clientDetails.getAuthorizedGrantTypes());
        System.out.println("Registered Redirect URI: " + clientDetails.getRegisteredRedirectUri());
    }
}