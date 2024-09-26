import org.springframework.security.access.prepost.PreAuthorize;

public class Temp1597 {
    public static void main(String[] args) {
        Temp1597 temp = new Temp1597();
        temp.secureMethod();
    }

    @PreAuthorize("#oauth2.hasScope('requiredScope')")
    public void secureMethod() {
        System.out.println("This method is secured with a scope check.");
    }
}