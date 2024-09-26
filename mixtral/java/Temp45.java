import java.security.SecureRandom;
import java.util.Base64;

interface PersonRepositoryCustom {
    void persist(Person person);
}

class Person {
    private String name;
    private String password;

    public Person(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class PersonRepositoryImpl implements PersonRepositoryCustom {

    @Override
    public void persist(Person person) {
        String salt = generateSalt();
        String saltedPassword = salt + person.getPassword();
        // Normally, you would hash the salted password here before storing it
        person.setPassword(saltedPassword);
        // Logic to save the person object to a database would go here
        System.out.println("Persisted person: " + person.getName() + " with salted password: " + person.getPassword());
    }

    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }

    public static void main(String[] args) {
        PersonRepositoryImpl repository = new PersonRepositoryImpl();
        Person person = new Person("John Doe", "password123");
        repository.persist(person);
    }
}