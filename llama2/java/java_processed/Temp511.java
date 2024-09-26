import org.apache.commons.lang3.SerializationUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Temp511 {
    public static void main(String[] args) {
        try {
            // Sample encrypted data (for demonstration purposes, replace with actual encrypted data)
            byte[] encryptedData = encrypt(new Employee("John Doe", 30));

            // Decrypt the encrypted data
            byte[] decryptedData = decrypt(encryptedData);

            // Deserialize the decrypted data
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(decryptedData));
            Employee employee = (Employee) in.readObject();
            in.close();

            // Print the deserialized Employee object
            System.out.println(employee);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Sample Employee class
    static class Employee implements Serializable {
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

    // Dummy encrypt method (for demonstration purposes)
    public static byte[] encrypt(Employee employee) {
        return SerializationUtils.serialize(employee);
    }

    // Dummy decrypt method (for demonstration purposes)
    public static byte[] decrypt(byte[] data) {
        return data;
    }
}