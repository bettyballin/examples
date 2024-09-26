import java.security.BasicPermission;

public class WebServiceConnectionPermission extends BasicPermission {
    public WebServiceConnectionPermission(String name) {
        super(name);
    }

    @Override
    public int hashCode() {
        return 123456789; // any unique value
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof WebServiceConnectionPermission) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        WebServiceConnectionPermission permission = new WebServiceConnectionPermission("examplePermission");
        System.out.println("Permission created: " + permission.getName());
    }
}