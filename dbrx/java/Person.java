public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    // Getters
    public String getName() {
        return name;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Person person = new Person("John");
        System.out.println("Name: " + person.getName());
        
        person.setName("Doe");
        System.out.println("Updated Name: " + person.getName());
    }
}