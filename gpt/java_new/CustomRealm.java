import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.authz.SimpleAuthorizationInfo;

public class CustomRealm extends AuthorizingRealm {
    // Implement necessary methods and constructors for CustomRealm

    public boolean roleHasPermission(String role, String permission) {
        Realm myRealm = getMyRealm(); // Assume this method is implemented

        if (myRealm instanceof AuthorizingRealm) {
            AuthorizingRealm authorizingRealm = (AuthorizingRealm) myRealm;
            SimpleAuthorizationInfo authorizationInfo = (SimpleAuthorizationInfo) authorizingRealm.getAuthorizationInfo(null);

            return authorizationInfo != null && authorizationInfo.getRoles().contains(role) &&
                   authorizationInfo.getStringPermissions().contains(permission);
        }
        return false;
    }

    private Realm getMyRealm() {
        // Implementation to retrieve the specific Realm instance
        return this; // Placeholder for the actual realm retrieval logic
    }
}