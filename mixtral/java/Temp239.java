import java.util.ArrayList;
import java.util.List;

class Interceptor {
    private Object securedObject;
    private List<String> rolesAllowed = new ArrayList<>();

    public void setSecuredObject(Object securedObject) {
        this.securedObject = securedObject;
    }

    public List<String> getRolesAllowed() {
        return rolesAllowed;
    }
}

public class Temp239 {
    public static void main(String[] args) {
        Interceptor interceptor1 = new Interceptor();
        Interceptor interceptor2 = new Interceptor();
        Object endpoint1 = new Object();
        Object endpoint2 = new Object();

        interceptor1.setSecuredObject(endpoint1);
        interceptor1.getRolesAllowed().add("ROLE_ADMIN");

        interceptor2.setSecuredObject(endpoint2);
        interceptor2.getRolesAllowed().add("ROLE_USER");
        interceptor2.getRolesAllowed().add("ROLE_GUEST");
    }
}