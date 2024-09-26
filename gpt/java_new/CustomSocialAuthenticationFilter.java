import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SocialAuthenticationServiceLocator;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.UserIdSource;
import org.springframework.social.connect.UsersConnectionRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomSocialAuthenticationFilter extends SocialAuthenticationFilter {
    private RememberMeServices rememberMeServices;

    public CustomSocialAuthenticationFilter(AuthenticationManager authManager,
                                            UserIdSource userIdSource,
                                            UsersConnectionRepository usersConnectionRepository,
                                            SocialAuthenticationServiceLocator authServiceLocator,
                                            String filterProcessesUrl) {
        super(authManager, userIdSource, usersConnectionRepository, authServiceLocator);
        setFilterProcessesUrl(filterProcessesUrl);
    }

    public void setRememberMeServices(RememberMeServices rememberMeServices) {
        this.rememberMeServices = rememberMeServices;
        super.setRememberMeServices(rememberMeServices);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        if (rememberMeServices != null && authResult.getPrincipal() instanceof UserDetails) {
            rememberMeServices.loginSuccess(request, response, authResult);
        }
    }
}