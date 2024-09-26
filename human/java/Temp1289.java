// Ensure you have the Jackson library included in your project dependencies. 
// If you are using Maven, include the following in your pom.xml:
// <dependency>
//     <groupId>com.fasterxml.jackson.core</groupId>
//     <artifactId>jackson-databind</artifactId>
//     <version>2.4.3</version>
// </dependency>

import com.fasterxml.jackson.databind.ObjectMapper;

public class Temp1289 {
    public static void main(String[] args) {
        // Example usage of Jackson ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Sample JSON string
        String jsonString = "{\"name\":\"John\", \"age\":30}";

        try {
            // Deserialize JSON string to Java object
            Person person = objectMapper.readValue(jsonString, Person.class);
            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());

            // Serialize Java object to JSON string
            String serializedJson = objectMapper.writeValueAsString(person);
            System.out.println("Serialized JSON: " + serializedJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define a simple Person class
    public static class Person {
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
    }
}