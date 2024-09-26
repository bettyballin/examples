import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

@Order(1)
public class AnnotationWebAppInitializer implements WebApplicationInitializer {
    // Implementation goes here
}

@Order(2)
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    // Implementation goes here
}

@Order(3)
public class SpringSessionInitializer extends AbstractHttpSessionApplicationInitializer {
    // Implementation goes here
}