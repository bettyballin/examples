import org.springframework.security.access.prepost.PreAuthorize;

public class Temp2013 {
    public static void main(String[] args) {
        Temp2013 temp = new Temp2013();
        Contact contact = new Contact();
        temp.create(contact);
    }

    @PreAuthorize("hasRole('USER')")
    public void create(Contact contact) {
        System.out.println("Contact created: " + contact);
    }
}

class Contact {
    // Assume some fields and methods for Contact class
    @Override
    public String toString() {
        return "Contact{}";
    }
}