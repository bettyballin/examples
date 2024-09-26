public class Temp348 {

    public static void main(String[] args) {
        Temp348 temp = new Temp348();
        ThreadGroup tg = new ThreadGroup("system");
        temp.checkAccess(tg);
        
        Thread t = new Thread(tg, "SIGTERM handler");
        temp.checkAccess(t);
    }

    public void checkAccess(ThreadGroup g) {
        System.out.println("Access for " + g);
        if ("system".equals(g.getName())) {
            // will checkPermission java.lang.RuntimePermission "modifyThreadGroup"
            // super.checkAccess(g); // Commented out as we cannot call super in this context
        } else {
            throw new SecurityException("Access denied to " + g);
        }
    }

    public void checkAccess(Thread t) {
        System.out.println("Access for " + t);
        if ("SIGTERM handler".equals(t.getName())) {
            // will checkPermission java.lang.RuntimePermission "modifyThread"
            // super.checkAccess(t); // Commented out as we cannot call super in this context
        } else {
            throw new SecurityException("Access denied to " + t);
        }
    }
}