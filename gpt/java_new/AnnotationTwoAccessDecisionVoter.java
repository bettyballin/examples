import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.vote.AccessDecisionVoter;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Documented
@Stereotype
@Secured("AnnotationTwoAccessDecisionVoter")
public @interface AnnotationTwo {
}

@ApplicationScoped
@Named("AnnotationTwoAccessDecisionVoter")
public class AnnotationTwoAccessDecisionVoter implements AccessDecisionVoter {
    // Implementation of required methods from AccessDecisionVoter
    // Placeholder for checkPermission method
}