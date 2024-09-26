import javax.annotation.security.RolesAllowed;

public class Temp1746 {
    public static void main(String[] args) {
        Temp1746 temp = new Temp1746();
        temp.secureMethod();
    }

    @RolesAllowed("admin")
    public void secureMethod() {
        System.out.println("This method is secured and requires 'admin' role.");
    }
}