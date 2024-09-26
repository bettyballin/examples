public class MySecurityManager2 extends SecurityManager {
    private final String authorizedClassName;

    public MySecurityManager2(String authorizedClassName) {
        this.authorizedClassName = authorizedClassName;
    }

    @Override
    public void checkExit(int status) {
        super.checkExit(status);

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        if (stackTraceElements.length > 3) {
            StackTraceElement caller = stackTraceElements[3];
            if (!caller.getClassName().equals(authorizedClassName)) {
                throw new SecurityException("Unauthorized call to System.exit()");
            }
        }
    }
}