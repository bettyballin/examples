import java.security.Principal;

public class MyPrincipal implements Principal {

    private final String businessId;
    private final String username;

    public MyPrincipal(String businessId, String username) {
        this.businessId = businessId;
        this.username = username;
    }

    @Override
    public String getName() {
        return username + "@" + businessId;
    }

    public static void main(String[] args) {
        MyPrincipal principal = new MyPrincipal("12345", "john_doe");
        System.out.println(principal.getName());
    }
}