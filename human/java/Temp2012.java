import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;

public class Temp2012 {
    public static void main(String[] args) {
        String initVector = "000102030405060708090a0b0c0d0e0f"; // Example initialization vector
        IvParameterSpec iv = new IvParameterSpec(
            DatatypeConverter.parseHexBinary(initVector));
        
        System.out.println("IV created successfully: " + iv);
    }
}