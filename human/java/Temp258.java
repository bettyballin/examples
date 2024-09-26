class Temp258 {
    public static void main(String[] args) {
        TestFacade testFacade = new TestFacade();
        int userId = 1; // example userId
        Person person = testFacade.findPersonIdByUserId(userId);
        if (person != null) {
            System.out.println("Person found: " + person.getName());
        } else {
            System.out.println("Person not found");
        }
    }
}

class TestFacade {
    public Person findPersonIdByUserId(int userId) {
        // Simulating a lookup
        if (userId == 1) {
            return new Person(1, "John Doe");
        } else {
            return null;
        }
    }
}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}