import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) throws IOException {
        //Header response
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");

        //Error Status, that you want to return, 401, 404, ....
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        //Message that will be showed at screen
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 - " + authEx.getMessage());
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("NO MATTER WICH NAME");
        super.afterPropertiesSet();
    }
}