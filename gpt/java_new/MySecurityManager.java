public class MySecurityManager extends SecurityManager {
    
    @Override
    public void checkRead(String file) {
        // Perform the standard security check
        super.checkRead(file);
        
        // Inspect the current execution stack to find the caller
        Class<?>[] context = getClassContext();
        if (context != null) {
            for (Class<?> cls : context) {
                // Process the class to determine if the access should be allowed
                // You can check the class name, package, etc.
                System.out.println(cls.getName());
            }
        }
    }
}