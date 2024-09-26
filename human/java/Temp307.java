import org.springframework.security.access.prepost.PreAuthorize;

public class Temp307 {
    public static void main(String[] args) {
        Temp307 temp = new Temp307();
        temp.displayLink();
    }

    @PreAuthorize("hasRole('supervisor')")
    public void displayLink() {
        System.out.println("<a href=\"edit\">edit</a>");
    }
}