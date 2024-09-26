import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final ObjectMapper mapper;

    public CustomAuthenticationFilter(ObjectMapper mapper) {
        super(new AntPathRequestMatcher("/auth/login", "POST"));
        this.mapper = mapper;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException, IOException,
            ServletException {

        MyPrincipal principal = mapper.readValue(request.getInputStream(), MyPrincipal.class);
        MyAuthentication authentication = new MyAuthentication(principal);
        setDetails(request, authentication); //assuming you are extending AbstractAuthenticationToken
        return getAuthenticationManager().authenticate(authentication);

    }

    protected void setDetails(HttpServletRequest request,
                              MyAuthentication authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }
}

class MyPrincipal {
    // Add fields and methods here
}

class MyAuthentication extends AbstractAuthenticationToken {
    private final MyPrincipal principal;

    public MyAuthentication(MyPrincipal principal) {
        super(null);
        this.principal = principal;
        setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}