import javax.crypto.*;
import javax.crypto.spec.*;

public class Temp32 {
    public static void main(String[] args) {

        // ...

        String myIv = new String(new byte[] {
            0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38,
            0x39
        });
        
        System.out.println(myIv);
    }
}