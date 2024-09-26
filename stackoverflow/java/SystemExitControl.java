import java.security.Permission;

public class SystemExitControl {

  private static class ExitTrappedException extends SecurityException { }

  private static void forbidSystemExitCall() {
    final SecurityManager securityManager = new SecurityManager() {
      @Override
      public void checkPermission(Permission permission) {
        if (permission.getName().startsWith("exitVM")) {
          throw new ExitTrappedException();
        }
      }
    };
    System.setSecurityManager(securityManager);
  }

  private static void enableSystemExitCall() {
    System.setSecurityManager(null);
  }

  public static void main(String[] args) {
    forbidSystemExitCall();
    try {
      System.exit(0);
    } catch (ExitTrappedException e) {
      System.out.println("System.exit was called and caught!");
    }
    enableSystemExitCall();
  }
}