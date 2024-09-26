import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

public class YourClass10 {

    private JdbcClientDetailsService jdbcClientDetailsService;

    @Autowired
    public YourClass10(JdbcClientDetailsService jdbcClientDetailsService) {
        this.jdbcClientDetailsService = jdbcClientDetailsService;
    }

    public void addClientDetails(String companyId, String resourceIds, String scopes, String grantTypes, String authorities) {
        BaseClientDetails clientDetails = new BaseClientDetails(companyId, resourceIds, scopes, grantTypes, authorities);
        clientDetails.setClientSecret("generatedpassword");
        jdbcClientDetailsService.addClientDetails(clientDetails);
    }
}