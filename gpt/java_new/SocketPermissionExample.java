import java.security.*;
import java.net.SocketPermission;

public class SocketPermissionExample {
  public static void main(String[] args) {
    PermissionCollection perms = new Permissions();
    SocketPermission socketPermission = new SocketPermission("10.130.71.156:8000", "connect,resolve");
    perms.add(socketPermission);
    
    // Set the policy with these permissions if you have the security manager enabled
    Policy.setPolicy(new Policy() {
      @Override
      public PermissionCollection getPermissions(CodeSource codesource) {
        return perms;
      }
    });

    if (System.getSecurityManager() == null) {
      System.setSecurityManager(new SecurityManager());
    }

    // Code that requires the specified SocketPermission should go here
  }
}