import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class MyBean {

    public boolean getIsUserAdmin() {
        return FacesContext.getCurrentInstance().getExternalContext().isUserInRole("ROLE_ADMIN");
    }
}