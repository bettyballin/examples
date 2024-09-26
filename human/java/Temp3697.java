import java.util.Optional;

class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException(String message) {
        super(message);
    }
}

class Person {
    private String username;

    public Person(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

public class Temp3697 {
    public static void main(String[] args) {
        Optional<Person> person = Optional.ofNullable(null);

        if (person.isEmpty())
            throw new UsernameNotFoundException("User not found");
    }
}