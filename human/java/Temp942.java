import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class Temp942 {
    public static void main(String[] args) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        // Example data to write to the ByteArrayOutputStream
        String exampleData = "Hello, world!";
        try {
            os.write(exampleData.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String file_string = new String(os.toByteArray(), StandardCharsets.UTF_8);
        System.out.println(file_string);
    }
}