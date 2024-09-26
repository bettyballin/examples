import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomAuthenticationToken1 extends UsernamePasswordAuthenticationToken {
    private String companyName;

    public CustomAuthenticationToken1(Object principal, Object credentials, String companyName) {
        super(principal, credentials);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }
}

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        String companyName = request.getParameter("companyName");

        CustomAuthenticationToken1 authRequest = new CustomAuthenticationToken1(username, password, companyName);
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}