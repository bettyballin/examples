import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;

public class Temp984 {
    public static void main(String[] args) {

        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setAccessTokenConverter(accessTokenConverter());

    }

    private static AccessTokenConverter accessTokenConverter() {
        return new DefaultAccessTokenConverter();
    }
}