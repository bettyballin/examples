import java.security.*;

public class Temp359 {
    public static void main(String[] args) {
        // Automatically generated on Tue Apr 16 17:20:59 EDT 2002
        // Do not edit

        Policy.setPolicy(new Policy() {
            public PermissionCollection getPermissions(CodeSource codesource) {
                Permissions perms = new Permissions();
                perms.add(new AllPermission());
                return perms;
            }

            public void refresh() {
                // No need to implement
            }
        });

        System.setSecurityManager(new SecurityManager());

        System.out.println("Security manager set with all permissions.");
    }
}