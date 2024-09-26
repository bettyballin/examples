public class CustomSecurityManager extends SecurityManager {

    @Override
    public void checkAccess(ThreadGroup g) {
        System.out.println("Access for " + g);
        if ("system".equals(g.getName())) {
            super.checkAccess(g);
        } else {
            throw new SecurityException("Access denied to " + g);
        }
    }

    @Override
    public void checkAccess(Thread t) {
        System.out.println("Access for " + t);
        if ("SIGTERM handler".equals(t.getName())) {
            super.checkAccess(t);
        } else {
            throw new SecurityException("Access denied to " + t);
        }
    }
}