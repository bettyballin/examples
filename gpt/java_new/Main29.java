import java.text.Normalizer;

public class Main29 {
    public static void main(String[] args) {
        String inputString = "Your input string here";
        String normalized = Normalizer.normalize(inputString, Normalizer.Form.NFC);
        System.out.println(normalized);
    }
}