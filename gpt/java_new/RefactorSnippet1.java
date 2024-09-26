import java.util.Base64;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class RefactorSnippet1 {
    public static void main(String[] args) {
        try {
            PrintStream out = System.out;
            String c = "Sample string to encrypt";
            out.println(c);
            String cipherTextBase64 = Base64.getEncoder().encodeToString(c.getBytes("UTF-8"));
            out.println(cipherTextBase64);
            byte[] cHB = cipherTextBase64.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}