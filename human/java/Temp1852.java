import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Temp1852 {
    public static void main(String[] args) {
        byte[] decoded = "decoded".getBytes();
        String decodedKey = "decoded";
        
        assertThat(decoded, equalTo(decodedKey.getBytes()));
    }
}