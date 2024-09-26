public class Main {

    public static void main(String[] args) {
        SecurityManager sm = new CustomSecurityManager();
        System.setSecurityManager(sm);

        try {
            System.exit(0);
        } catch (SecurityException se) {
            System.out.println(se.getMessage());
        }
    }

    static class CustomSecurityManager extends SecurityManager {

        @Override
        public void checkExit(int status) {
            final StackTraceElement[] steArray = Thread.currentThread().getStackTrace();

            boolean foundCallerClass = false;

            for (int i = 0; i < steArray.length && !foundCallerClass; ++i) {
                if ("Main".equals(steArray[i].getClassName())) {
                    foundCallerClass = true;
                }
            }

            // If the caller class is not Main throw a SecurityException
            if (!foundCallerClass) {
                throw new SecurityException("System exit called by unauthorized class");
            }
        }

        @Override
        public void checkPermission(java.security.Permission perm) {
            // Allow other permissions by default
        }
    }
}