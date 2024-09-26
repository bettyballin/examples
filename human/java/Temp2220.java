import java.io.FilePermission;
import java.security.AllPermission;
import java.security.Permission;
import java.security.Permissions;

public class Temp2220 {
    public static void main(String[] args) {
        Permissions standardExtensionsPermissions = new Permissions();
        standardExtensionsPermissions.add(new AllPermission());

        Permissions defaultPermissions = new Permissions();

        Permissions trustedCodePermissions = new Permissions();
        trustedCodePermissions.add(new AllPermission());

        Permissions thirdPartyCodePermissions = new Permissions();
        thirdPartyCodePermissions.add(new RuntimePermission("exitVM.-1"));

        System.out.println("Standard Extensions Permissions: " + standardExtensionsPermissions);
        System.out.println("Default Permissions: " + defaultPermissions);
        System.out.println("Trusted Code Permissions: " + trustedCodePermissions);
        System.out.println("Third-Party Code Permissions: " + thirdPartyCodePermissions);
    }
}