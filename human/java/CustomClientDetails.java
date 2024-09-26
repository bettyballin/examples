import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Inject;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

// Assuming Customer class is defined like this
class Customer {
    public Integer getAccessTokenValidity() {
        return 3600;
    }

    public String getAdditionalInformation() {
        return "additionalInfo";
    }

    public String getAuthorities() {
        return "ROLE_USER";
    }

    public String getAuthorizedGrantTypes() {
        return "authorization_code";
    }

    public String getClientId() {
        return "clientId";
    }

    public String getClientSecret() {
        return "clientSecret";
    }

    public Integer getRefreshTokenValidity() {
        return 7200;
    }

    public String getWebServerRedirectUri() {
        return "http://redirect.uri";
    }

    public String getResourceIds() {
        return "resourceId";
    }

    public String getScope() {
        return "read";
    }
}

// Assuming CustomerService class is defined like this
class CustomerService {
    public Customer getCustomerByClientId(String clientId) {
        return new Customer(); // Mock implementation
    }
}

public class CustomClientDetails implements ClientDetails {

    final static Logger log = LoggerFactory.getLogger(CustomClientDetailsManager.class);

    private static final long serialVersionUID = 6725149038554040628L;

    private Customer customer;

    public CustomClientDetails(final Customer customer) {
        this.customer = customer;       
    }       

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return customer.getAccessTokenValidity();
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        final Set<String> additionalInformation = new HashSet<>();
        additionalInformation.add(customer.getAdditionalInformation());
        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        final Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(customer.getAuthorities()));
        return authorities;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        final Set<String> authorizedGrantTypes = new HashSet<>();
        authorizedGrantTypes.add(customer.getAuthorizedGrantTypes());
        return authorizedGrantTypes;
    }

    @Override
    public String getClientId() {
        return customer.getClientId();
    }

    @Override
    public String getClientSecret() {
        return customer.getClientSecret();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return customer.getRefreshTokenValidity();
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        final Set<String> registeredRedirectUris = new HashSet<>();
        registeredRedirectUris.add(customer.getWebServerRedirectUri());
        return registeredRedirectUris;
    }

    @Override
    public Set<String> getResourceIds() {
        final Set<String> resourcesIds = new HashSet<>();
        resourcesIds.add(customer.getResourceIds());
        return resourcesIds;
    }

    @Override
    public Set<String> getScope() {
        final Set<String> scopes = new HashSet<>();
        scopes.add(customer.getScope());            
        return scopes;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return false; //TODO: for some reason this is always false
    }

    @Override
    public boolean isScoped() {         
        return true; //TODO: for some reason this is always true
    }

    @Override
    public boolean isSecretRequired() {         
        return true; //TODO: for some reason this is always true
    }

}

public class CustomClientDetailsManager implements ClientDetailsService {

    final static Logger log = LoggerFactory.getLogger(CustomClientDetailsManager.class);

    private final CustomerService customerService;

    @Inject
    public CustomClientDetailsManager(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        final Customer customer = customerService.getCustomerByClientId(clientId);  

        final CustomClientDetails customClientDetails = new CustomClientDetails(customer);

        return customClientDetails;
    }
}