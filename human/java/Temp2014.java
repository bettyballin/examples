import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.acls.model.Permission;
import org.springframework.security.acls.model.Sid;

public class Temp2014 {

    public static void main(String[] args) {
        Temp2014 temp = new Temp2014();
        Contact contact = new Contact();
        Sid recipient = new UserSid("username");
        Permission permission = new CustomPermission("admin");

        temp.deletePermission(contact, recipient, permission);
    }

    @PreAuthorize("hasPermission(#contact, 'admin')")
    public void deletePermission(Contact contact, Sid recipient, Permission permission){
        // Implementation of the method
        System.out.println("Permission deleted.");
    }
}

class Contact {
    // Contact class implementation
}

class UserSid implements Sid {
    private String username;

    public UserSid(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

class CustomPermission implements Permission {
    private String permission;

    public CustomPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

    @Override
    public int getMask() {
        return 0;
    }

    @Override
    public String getPattern() {
        return null;
    }
}