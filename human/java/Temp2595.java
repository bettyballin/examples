import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Temp2595 {
    public static void main(String[] args) {
        String signature = "exampleSignature";
        String encoding = StandardCharsets.UTF_8.name();
        
        try {
            StringEntity se = new StringEntity("signature=" + URLEncoder.encode(signature, encoding));
            System.out.println(se);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class StringEntity {
    private String content;

    public StringEntity(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}