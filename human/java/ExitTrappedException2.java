import java.security.Permission;

public class Main {
  private static class ExitTrappedException extends SecurityException { }

  private static void forbidSystemExitCall() {
    final SecurityManager securityManager = new SecurityManager() {
      public void checkPermission(Permission permission) {
        if ("exitVM".equals(permission.getName())) {
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
    try {
      forbidSystemExitCall();
      System.exit(0);
    } catch (ExitTrappedException e) {
      System.out.println("System.exit() call was trapped!");
    } finally {
      enableSystemExitCall();
    }
  }
}