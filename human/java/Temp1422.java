import org.springframework.security.access.prepost.PreAuthorize;

public class Temp1422 {

    @PreAuthorize("isAuthenticated() and hasPermission(#opetussuunnitelmaDto, 'LUONTI')")
    public void performAction(Object opetussuunnitelmaDto) {
        // Action logic here
        System.out.println("Action performed!");
    }

    public static void main(String[] args) {
        Temp1422 temp = new Temp1422();
        Object dummyDto = new Object(); // Replace with actual DTO object as needed
        temp.performAction(dummyDto);
    }
}