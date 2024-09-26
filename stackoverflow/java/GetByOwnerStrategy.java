import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.aop.MethodInvocation;

public class GetByOwnerStrategy implements AccessDecisionStrategy {
    @Override
    public void decide(Authentication authentication,
                       MethodInvocation methodInvocation, ConfigAttribute configAttribute) 
            throws AccessDeniedException {

        MethodInvocationExtractor extractor = new MethodInvocationExtractor(methodInvocation);
        Person person = (Person) extractor.getArg(0);
        String userId = (String) extractor.getArg(1);

        String username = authentication.getName();

        if (!userId.equals(username) || !person.getSomeData().equals("SOMETHING")) {
            throw new AccessDeniedException("Not enough privileges");
        }
    }

    private class MethodInvocationExtractor {
        private MethodInvocation methodInvocation;

        public MethodInvocationExtractor(MethodInvocation methodInvocation) {
            this.methodInvocation = methodInvocation;
        }

        public Object getArg(int index) {
            return methodInvocation.getArguments()[index];
        }
    }
    
    private class Person {
        String getSomeData() {
            // Implementation Details
            return "SOMETHING";
        }
    }
    
    private interface AccessDecisionStrategy {
        void decide(Authentication authentication,
                    MethodInvocation methodInvocation, ConfigAttribute configAttribute) 
                throws AccessDeniedException;
    }
}