import org.springframework.security.access.prepost.PreAuthorize;

public class Temp2568 {
    public static void main(String[] args) {
        Temp2568 temp = new Temp2568();
        System.out.println(temp.yourControllerMethod());
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String yourControllerMethod() {
        String response = "Authorized Response";
        return response;
    }
}