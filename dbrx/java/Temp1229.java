import javax.xml.bind.DatatypeConverter;

public class Temp1229 {
    public static void main(String[] args) {
        String base64Key = "uQsaW+WMUrjcsq1HMf+2JQ==";
        byte[] decodedKey = java.util.Base64.getDecoder().decode(base64Key);
        String hexKey = java.util.HexFormat.of().formatHex(decodedKey);
        
        System.out.println("Hex Key: " + hexKey);
    }
}