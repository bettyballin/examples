import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Custom Secured annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Secured {
    String[] value();
}

// Dummy Contact class
class Contact {
    private String name;

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Temp2351 {

    @Secured({ "ROLE_USER" })
    public void create(Contact contact) {
        System.out.println("Creating contact: " + contact.getName());
    }

    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    public void update(Contact contact) {
        System.out.println("Updating contact: " + contact.getName());
    }

    @Secured({ "ROLE_ADMIN" })
    public void delete(Contact contact) {
        System.out.println("Deleting contact: " + contact.getName());
    }

    public static void main(String[] args) {
        Temp2351 temp = new Temp2351();
        Contact contact = new Contact("John Doe");

        temp.create(contact);
        temp.update(contact);
        temp.delete(contact);
    }
}