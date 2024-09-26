import javax.security.auth.x500.X500Principal;

public class Temp209 {
    public static void main(String[] args) {
        // For demonstration, create a dummy X500Principal.
        String dummyDN = "CN=Dummy Signer, OU=Test, O=Example, L=City, ST=State, C=US";
        X500Principal signingCertificate = new X500Principal(dummyDN);

        String expectedSigner = "CN=Dummy Signer, OU=Test, O=Example, L=City, ST=State, C=US";
        String actualSignerName = signingCertificate.getName("RFC1779");

        if (expectedSigner.equals(actualSignerName)) {
            System.out.println("Assertion passed!");
        } else {
            System.out.println("Assertion failed!");
        }
    }
}