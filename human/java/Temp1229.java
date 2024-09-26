import org.springframework.security.core.annotation.AuthenticationPrincipal;

public class Temp1229 {
    public static void main(String[] args) {
        Temp1229 temp = new Temp1229();
        CustomUser customUser = new CustomUser(); // Assuming CustomUser has a default constructor
        System.out.println(temp.show(customUser));
    }

    public String show(@AuthenticationPrincipal CustomUser customUser) {
        // do something with CustomUser
        return "view";
    }
}

class CustomUser {
    // Define necessary fields and methods for CustomUser
}