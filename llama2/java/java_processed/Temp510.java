import org.apache.commons.lang3.SerializationUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Temp510 {

    public static void main(String[] args) throws IOException {
        // Create an example employee object
        Employee employee = new Employee("John Doe", 30);

        // Encrypt the employee object
        byte[] encryptedData = encrypt(employee);

        // Serialize the employee object
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(employee);
        out.close();

        // Encrypt the serialized data
        encryptedData = encrypt(bos.toByteArray());

        // Print the encrypted data for demonstration
        System.out.println(java.util.Arrays.toString(encryptedData));
    }

    private static byte[] encrypt(Object object) {
        // Example encryption: just converting the object to bytes using serialization
        return SerializationUtils.serialize((java.io.Serializable) object);
    }

    // Simple Employee class for demonstration purposes
    static class Employee implements java.io.Serializable {
        private String name;
        private int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Employee{name='" + name + "', age=" + age + "}";
        }
    }
}