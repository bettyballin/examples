import java.util.concurrent.ConcurrentHashMap;

public class CustomSecurityPolicyManager {

    private ConcurrentHashMap<Thread, SecurityPolicy> threadPolicies = new ConcurrentHashMap<>();

    public void associateWithSecurityPolicy(Thread thread, SecurityPolicy policy) {
        threadPolicies.put(thread, policy);
    }

    public SecurityPolicy getSecurityPolicy(Thread thread) {
        return threadPolicies.get(thread);
    }

}

class SecurityPolicy {
    // Implementation of SecurityPolicy
}