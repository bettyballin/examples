import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        try {
            String jsonInputString = "{\"name\":\"John\", \"age\":30}"; // Example JSON string

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

            MyClass myObj = objectMapper.readValue(jsonInputString, MyClass.class);
            System.out.println(myObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyClass {
    private String name;
    private int age;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyClass{name='" + name + "', age=" + age + "}";
    }
}