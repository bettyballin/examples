import org.springframework.security.access.prepost.PreAuthorize;

public class Temp1421 {
    public static void main(String[] args) {
        Temp1421 temp = new Temp1421();
        temp.secureMethod(new Object()); // Call the method for demonstration
    }

    @PreAuthorize("hasPermission(#opetussuunnitelmaDto, 'LUONTI')")
    public void secureMethod(Object opetussuunnitelmaDto) {
        // Method implementation here
        System.out.println("Method executed with: " + opetussuunnitelmaDto);
    }
}