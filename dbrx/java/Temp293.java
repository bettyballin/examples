import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Temp293 {
    public static void main(String[] args) {
        Temp293 instance = new Temp293();
        instance.methodToProtect();
    }

    @PreAuthorize("hasRole('READ_ONLY') or !authentication.name.matches('specificUser1|specificUser2')")
    public void methodToProtect() {
        // Example method implementation
        System.out.println("Method to protect executed.");
    }
}


Alternatively:


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Temp293 {
    public static void main(String[] args) {
        Temp293 instance = new Temp293();
        instance.methodToProtect();
    }

    @PreAuthorize("hasRole('READ_ONLY') or !#username.matches('specificUser1|specificUser2')")
    public void methodToProtect(String username) {
        // Example method implementation
        System.out.println("Method to protect executed.");
    }
}


Usage for the second option:


Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
String username = authentication.getName();
Temp293 instance = new Temp293();
instance.methodToProtect(username);