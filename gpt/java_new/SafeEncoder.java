import org.owasp.encoder.Encode;

public class SafeEncoder {
    public static void main(String[] args) {
        String unsafeData = "dataToEncode"; // Replace with the actual data
        String safeData = Encode.forHtml(unsafeData);
        System.out.println(safeData);
    }
}