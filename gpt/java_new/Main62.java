import javax.xml.bind.DatatypeConverter;

public class Main62 {
    public static void main(String[] args) {
        byte[] test = "a
".getBytes(); // Note the newline character 

        byte[] key = DatatypeConverter.parseHexBinary("b38b730d4cc721156e3760d1d58546ce697adc939188e4c6a80f0e24e032b9b7");
        byte[] iv = DatatypeConverter.parseHexBinary("064df9633d9f5dd0b5614843f6b4b059");
        // Continue with your code
    }
}