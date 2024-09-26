public class CustomSecurityManager extends SecurityManager {

    private String allowedPackagePrefix;

    public CustomSecurityManager(String allowedPackagePrefix) {
        super();
        this.allowedPackagePrefix = allowedPackagePrefix;
    }

    @Override
    public void checkExit(int status) {
        Class<?>[] context = getClassContext();
        if (context != null && context.length > 1) {
            String className = context[context.length - 1].getName();
            if (className.startsWith(allowedPackagePrefix)) {
                return;
            }
        }
        throw new SecurityException("Calling System.exit is not allowed");
    }
}