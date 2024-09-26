import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.intercept.FilterInvocation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Temp1339 {
    private static AccessDecisionManager accessDecisionManager;

    public static void main(String[] args) {
        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority("USER"));
        Authentication auth = new UsernamePasswordAuthenticationToken("username", "password", grantedAuths);

        FilterInvocation filterInvocation = new FilterInvocation("/accounts/123");
        filterInvocation.getHttpRequest().setAttribute(WebAsyncManagerIntegrationFilter.FILTER_APPLIED, true);

        accessDecisionManager.decide(auth, filterInvocation, null);
    }
}