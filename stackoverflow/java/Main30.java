import java.util.UUID;

public class Main30 {
    public static void main(String[] args) {
        String serial = UUID.randomUUID().toString().toUpperCase();
        System.out.println(serial);
    }
}