import org.springframework.security.access.prepost.PreAuthorize;

public class Temp729 {

    public static final String ROLE = "ROLE_USER";

    public static void main(String[] args) {
        Temp729 instance = new Temp729();
        instance.secureMethod();
    }

    @PreAuthorize("hasRole(T(Temp729).ROLE)")
    public void secureMethod() {
        System.out.println("This method is secured!");
    }
}