import java.util.Set;
import java.util.HashSet;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

// Define necessary interfaces and classes
interface AccessDecisionVoter {
    Set<SecurityViolation> checkPermission(AccessDecisionVoterContext voteContext) throws Exception;
}

class SecurityViolation {
    // Implementation details
}

class AccessDecisionVoterContext {
    private Object annotation;

    public AccessDecisionVoterContext(Object annotation) {
        this.annotation = annotation;
    }

    public Object getAnnotation() {
        return annotation;
    }
}

interface AnnotationOne {}

interface AnnotationTwo {}

@ApplicationScoped
public class CompositeAccessDecisionVoter implements AccessDecisionVoter {

    @Inject
    private AnnotationOneAccessDecisionVoter ann1;

    @Inject
    private AnnotationTwoAccessDecisionVoter ann2;

    @Override
    public Set<SecurityViolation> checkPermission(final AccessDecisionVoterContext voteContext) throws Exception {
        if (voteContext.getAnnotation() instanceof AnnotationOne) {
            return ann1.checkPermission(voteContext);
        } else if (voteContext.getAnnotation() instanceof AnnotationTwo) {
            return ann2.checkPermission(voteContext);
        }

        // Return empty set or throw exception for unsupported annotations
        return new HashSet<>();
    }
}

@ApplicationScoped
class AnnotationOneAccessDecisionVoter implements AccessDecisionVoter {
    @Override
    public Set<SecurityViolation> checkPermission(AccessDecisionVoterContext voteContext) throws Exception {
        // Implementation for checking permission for AnnotationOne
        return new HashSet<>();
    }
}

@ApplicationScoped
class AnnotationTwoAccessDecisionVoter implements AccessDecisionVoter {
    @Override
    public Set<SecurityViolation> checkPermission(AccessDecisionVoterContext voteContext) throws Exception {
        // Implementation for checking permission for AnnotationTwo
        return new HashSet<>();
    }
}