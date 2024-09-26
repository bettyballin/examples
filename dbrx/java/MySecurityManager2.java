import java.lang.reflect.Member;
import java.security.AccessControlException;

public class MySecurityManager extends SecurityManager {
    @Override
    public void checkMemberAccess(Class<?> clazz, int which) {
        if (which == Member.PUBLIC && !clazz.getName().equals("MySecurityManager")) {
            throw new AccessControlException("Reflection access denied");
        }
    }

    // Override other methods as needed.
    
    public static void main(String[] args) {
        System.setSecurityManager(new MySecurityManager());
        // Test the security manager
        try {
            Class<?> testClass = Class.forName("MySecurityManager");
            testClass.getMethods();
            System.out.println("Access granted to MySecurityManager");
        } catch (AccessControlException ex) {
            System.out.println("AccessControlException: " + ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}