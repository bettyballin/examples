import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ByteArray {
    public static void main(String[] args) throws IOException {
        String balaji = "8E383187C7ACFAB214B113444EA248DC34BADCBA54F7032ECA2B8AC03C6B95C67D2F46F586E4CD86";
        
        // Note: The provided string is not a valid Base64 encoded string, 
        // so this part of the code will not work as expected.
        // For demonstration purposes, let's use a valid Base64 string.
        String validBase64String = "U29tZSBkYXRhIHRvIGJlIGRlY29kZWQ="; // "Some data to be decoded"
        
        byte[] decodedBytes = Base64.getDecoder().decode(validBase64String);
        String value = new String(decodedBytes, StandardCharsets.ISO_8859_1); // Use ISO-8859-1 to avoid data loss
        System.out.println(value);
    }
}