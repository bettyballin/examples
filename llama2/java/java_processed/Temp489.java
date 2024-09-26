import java.security.spec.ECGenParameterSpec;

public class Temp489 {
    public static void main(String[] args) {
        ECGenParameterSpec ecParams = new ECGenParameterSpec("secp256r1");
        System.out.println("ECGenParameterSpec created with name: " + ecParams.getName());
    }
}