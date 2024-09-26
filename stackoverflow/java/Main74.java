import java.math.BigInteger;
import java.util.Base64;

// Assuming jsonKey is an instance of a class that has getN() and getE() methods returning strings
public class Main74 {
    public static void main(String[] args) {
        BigInteger modulus = new BigInteger(1, Base64.getUrlDecoder().decode(jsonKey.getN()));
        BigInteger exponent = new BigInteger(1, Base64.getUrlDecoder().decode(jsonKey.getE()));
        // additional logic
    }
}

class JsonKey {
    private String n;
    private String e;
    
    // Constructor, getters, and setters for n and e
    public JsonKey(String n, String e) {
        this.n = n;
        this.e = e;
    }
    
    public String getN() {
        return n;
    }
    
    public String getE() {
        return e;
    }
    
    public void setN(String n) {
        this.n = n;
    }
    
    public void setE(String e) {
        this.e = e;
    }
}