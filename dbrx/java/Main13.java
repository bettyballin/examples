import java.io.ByteArrayInputStream;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {

        String x5c = "MIIDBTCCAe2gAwIBAgIQZSAeaqWig4BHC1ksmNNcgjANBgkqhkiG9w0BAQsFADAtMSswKQYDVQQDEyJhY2NvdW50cy5hY2Nlc3Njb250cm9sLndpbmRvd3MubmV0MB4XDTE3MDUwNjAwMDAwMFoXDTE5MDUwNzAwMDAwMFowLTErMCkGA1UEAxMiYWNjb3VudHMuYWNjZXNzY29udHJvbC53aW5kb3dzLm5ldDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJL7dVZkeJ8JDTPIzFNMJo9oEkvDc52zrdqWSOmex0E/3rBe1tfRmUe2O9l6NYuc10QzPaNxnkyIwa5698suNUPxGlEOwvm/h5oPeFcuxAWcgYYv5s589HWFrNjCF8EfOjZ4vU5oE1744EzxdmBiaGbeE8HDBXn1vK4owlcjawgQNF7KQ6LjSWr7xtARDF2IoKE4RYy0V0uVN4eAQ3zWRWWUt3cpYjTl34EZ9pO6CE8/If7noj75g0RYd/AHkIMdXBC4SlnNz+boLbba2ksIB+5z9jVILjvZwqx7i+k2filqZkagfghgf";

        // Decode the Base64 encoded certificate
        byte[] decodedBytes = Base64.getMimeDecoder().decode(x5c);

        // Create a CertificateFactory
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");

        // Create a ByteArrayInputStream from the decoded bytes
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decodedBytes);

        // Generate the X509Certificate
        X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);

        // Extract the public key from the certificate
        PublicKey publicKey = certificate.getPublicKey();

        // Print the public key
        System.out.println("Public Key: " + publicKey);
    }
}