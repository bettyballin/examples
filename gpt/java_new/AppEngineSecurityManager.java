public class AppEngineSecurityManager extends SecurityManager {
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new AppEngineSecurityManager());
        }
        // Rest of the application code goes here
    }

    @Override
    public void checkPackageAccess(String pkg) {
        super.checkPackageAccess(pkg);
        if (pkg.equals("javax.naming")) {
            throw new SecurityException("Access to package " + pkg + " is not allowed");
        }
    }
}