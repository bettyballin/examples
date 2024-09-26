public class Temp689 {
    public static void main(String[] args) {

        java.lang.SecurityManager appsm = System.getSecurityManager();
        System.out.println("something");
        if (appsm != null) {
            try {
                appsm.checkExit(0);
            } catch (java.lang.SecurityException e) {
                // Handle the exception here.
                System.out.println("SecurityException caught: " + e.getMessage());
            }
        }

    }
}