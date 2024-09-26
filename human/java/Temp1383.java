import java.util.Base64;

public class Temp1383 {
    public static void main(String[] args) {
        String name = "NIST P-256";
        int size = 256;
        byte[] head = createHeadForNamedCurve(name, size);
        System.out.println(Base64.getEncoder().encodeToString(head));
    }

    public static byte[] createHeadForNamedCurve(String name, int size) {
        // Dummy implementation, replace with actual logic
        return (name + size).getBytes();
    }
}