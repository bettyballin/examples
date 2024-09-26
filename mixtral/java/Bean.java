import javax.inject.Named;
import javax.enterprise.context.ViewScoped;
import java.io.Serializable;

// Permission
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;

@Named("bean")
@ViewScoped
@DeclareRoles({"USER", "ADMIN"})
@RolesAllowed("USER")
public class Bean implements Serializable {
    private static final long serialVersionUID = 1L;

    // Add your properties and methods here
}