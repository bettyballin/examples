import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.security.access.prepost.PreAuthorize;

@Component("appVariablesHolder")
public class AppVariablesHolder {

    @Value("${role.rolename}") 
    private String someRole;

    public String getSomeRole() {
        return this.someRole;
    }
}

class SomeClass {

    @PreAuthorize("hasRole(@appVariablesHolder.getSomeRole())")
    public void method() {}
}