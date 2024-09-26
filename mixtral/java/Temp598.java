import java.security.BasicPermission;

public class Temp598 {
    public static void main(String[] args) {
        // Assuming rep is defined somewhere in your actual code
        // rep.getAccessControlContext().checkPermission(new BasicPermissionWithActions("readFile", "read"));
    }
}

class BasicPermissionWithActions extends BasicPermission {
    private String actions;

    public BasicPermissionWithActions(String name, String actions) {
        super(name);
        this.actions = actions;
    }

    public String getActions() {
        return actions;
    }
}