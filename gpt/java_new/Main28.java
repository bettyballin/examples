import java.security.Provider;
import java.security.Security;

public class Main28 {
    private static final String PROVIDER_NAME = "BC";

    public static void main(String[] args) {
        Provider prov = Security.getProvider(PROVIDER_NAME);
        if (prov != null) {
            String originalAlg = "GOST3411withGOST3410EL";
            String aliasAlg = "GOST3411withECGOST3410";
            prov.put("Alg.Alias.Signature." + aliasAlg, originalAlg);
        } else {
            System.out.println("Provider " + PROVIDER_NAME + " not found");
        }
    }
}