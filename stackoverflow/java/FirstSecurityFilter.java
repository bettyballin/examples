import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;

// Assuming you have these filter classes defined somewhere
class FirstSecurityFilter extends BasicAuthenticationFilter {
    // Implementation details
}

class SecondSecurityFilter extends BasicAuthenticationFilter {
    // Implementation details
}

class ThirdSecurityFilter extends BasicAuthenticationFilter {
    // Implementation details
}

class MultiAuthModeSecurityFilter extends BasicAuthenticationFilter {
    public MultiAuthModeSecurityFilter(FirstSecurityFilter firstFilter, SecondSecurityFilter secondFilter, ThirdSecurityFilter thirdFilter) {
        // Assuming constructor logic here
    }
}