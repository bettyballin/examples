import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Qualifier;

@ApplicationPath("/api")
public class MyJaxRsApp extends Application {

    private Set<Object> singletons = new HashSet<>();

    @Inject
    public MyJaxRsApp(@SecurityContextFilterQualifier SecurityContextFilter securityContextFilter) {
        this.singletons.add(securityContextFilter);
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@interface SecurityContextFilterQualifier {}

class SecurityContextFilter {
    // Implementation of the filter
}