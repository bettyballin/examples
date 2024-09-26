public class CustomSecurityManager extends SecurityManager {
    @Override
    public void checkExit(int status) {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        for (int i = 0; i < Math.min(stack.length, 10); ++i) { // Limit to the top ten frames.
            if ("your.class.Name".equals(stack[i].getClassName())) {
                super.checkExit(status);
                return;
            }
        }

        throw new SecurityException("System.exit() is not allowed from this class.");
    }

    public static void main(String[] args) {
        System.setSecurityManager(new CustomSecurityManager());
        try {
            // Attempt to exit the JVM
            System.exit(0);
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}