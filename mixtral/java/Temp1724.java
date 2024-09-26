public class Temp1724 {
    public static void main(String[] args) {
        Temp1724 obj = new Temp1724();
        // Test the method here
        System.out.println(obj.isOwnerOfQuestion(1L, "username"));
    }

    public boolean isOwnerOfQuestion(Long id, String username) {
        Question q = findById(id);

        if (q != null && q.getPerson().getId().equals(getUserByUsername(username).getId())) {
            return true;
        }

        return false;
    }

    private Question findById(Long id) {
        // Dummy implementation for testing
        Person person = new Person(1L);
        return new Question(id, person);
    }

    private Person getUserByUsername(String username) {
        // Dummy implementation for testing
        return new Person(1L);
    }
}

class Question {
    private Long id;
    private Person person;

    public Question(Long id, Person person) {
        this.id = id;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }
}

class Person {
    private Long id;

    public Person(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}