import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class RoleBasedAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler
        implements AuthenticationSuccessHandler {

    private String adminRoleTargetUrl;
    private String adminRoleAuthority;

    public RoleBasedAuthenticationSuccessHandler(String defaultTargetUrl, String adminRoleTargetUrl, String adminRoleAuthority) {
        super(defaultTargetUrl);
        this.adminRoleTargetUrl = adminRoleTargetUrl;
        this.adminRoleAuthority = adminRoleAuthority;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        if(isAdmin(authentication)){
            this.getRedirectStrategy().sendRedirect(request, response, adminRoleTargetUrl);
            return;
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }

    protected boolean isAdmin(Authentication authentication) {
        for(GrantedAuthority authority : authentication.getAuthorities()){
            if(authority.getAuthority().equals(adminRoleAuthority)){
                return true;
            }
        }
        return false;
    }
}