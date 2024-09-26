public class RMISecurityManager extends SecurityManager {

    /**
     * Constructs a new &lt;code&gt;RMISecurityManager&lt;/code&gt;.
     * @since JDK1.1
     */
    public RMISecurityManager() {
        // super() is implicitly called here
    }

    public static void main(String[] args) {
        // Creating an instance of RMISecurityManager
        RMISecurityManager rmiSecurityManager = new RMISecurityManager();
        System.out.println("RMISecurityManager instance created: " + rmiSecurityManager);
    }
}