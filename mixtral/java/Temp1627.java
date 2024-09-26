import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;

public class Temp1627 {
    public static void main(String[] args) {
        // Example curve name
        String exampleCurveName = "secp256k1";
        
        // Retrieve the curve parameters based on the curve name
        ECNamedCurveParameterSpec params = ECNamedCurveTable.getParameterSpec(exampleCurveName);
        
        // Assuming we have the public key parameters (for illustration purposes)
        // In practice, you would obtain this from an actual public key
        String curveName = params.getName();
        
        // Print the curve name
        System.out.println("Curve Name: " + curveName);
    }
}