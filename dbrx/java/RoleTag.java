import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspException;
import java.io.IOException;

public class RoleTag extends SimpleTagSupport {

    private String roleName;

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            boolean hasRole = SecurityContextHolder.getContext()
                    .getAuthentication().getAuthorities()
                    .contains(new SimpleGrantedAuthority(roleName));
            getJspContext().setAttribute("role", hasRole);
        } else {
            getJspContext().setAttribute("role", false);
        }
    }
}