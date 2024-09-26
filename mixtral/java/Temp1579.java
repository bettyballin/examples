import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.web.RedirectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Temp1579 extends WebSecurityConfigurerAdapter {

    @Autowired
    private OAuth2ClientContextFilter oauth2ClientContextFilter;

    public static void main(String[] args) {
        // Your main method code here, if needed
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);

        // Customize your filter chain here
        FilterChainProxy filterChain = (FilterChainProxy) web.getSharedObject(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_CHAIN_PROXY_BEAN_NAME);

        for (int i = 0; i < filterChain.getFilters().size(); i++) {
            if (filterChain.getFilters().get(i) instanceof OAuth2ClientContextFilter) {
                oauth2ClientContextFilter = ((OAuth2ClientContextFilter) (filterChain.getFilters().get(i)));

                // Set your custom redirect strategy here
                oauth2ClientContextFilter.setRedirectStrategy(new RedirectStrategy() {
                    @Override
                    public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
                        // Your code here
                    }
                });
            }
        }
    }
}