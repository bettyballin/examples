import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationProcessingFilter extends UsernamePasswordAuthenticationFilter {
    private LoginDao loginDao;

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException {
        super.successfulAuthentication(request, response, authResult);    
        request.getSession().setAttribute("wrong", -1); 
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        super.unsuccessfulAuthentication(request, response, authException);
        String username = obtainUsername(request);
        if(username != null && username.length() > 0){
            Login login = loginDao.read(username);
            if(login != null){
                request.getSession().setAttribute("wrong", login.getFailedLoginAttempts());
                request.getSession().setAttribute("attempts", Login.MAX_FAILED_LOGIN_ATTEMPTS);
            }else{
                request.getSession().setAttribute("wrong", 100);
            }
        }else{
            request.getSession().setAttribute("wrong", -1);
        }
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
}