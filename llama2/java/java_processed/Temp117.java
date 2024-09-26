import java.util.UUID;

public class Temp117 {
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        String code = uuid.substring(0, 9);
        System.out.println("Generated Code: " + code);
    }
}