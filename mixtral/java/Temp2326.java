import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.security.saml2.credentials.Saml2X509Credential;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrations;

public class Temp2326 {
    public static void main(String[] args) {
        String registrationId = "exampleRegistrationId";

        // Creating dummy credentials for demonstration purposes
        Saml2X509Credential signingCredential = createDummyCredential();
        Saml2X509Credential idpVerificationCertificate = createDummyCredential();

        RelyingPartyRegistration relyingPartyRegistration = RelyingPartyRegistrations
            .withRegistrationId(registrationId)
            .credentials((c) -> c.addAll(List.of(
                new Saml2X509CredentialDecorator(signingCredential).getEncoded(),
                new Saml2X509CredentialDecorator(idpVerificationCertificate).getEncoded()
            )))
            .build();

        // Dummy print to show that the code executes
        System.out.println("Relying Party Registration created successfully: " + relyingPartyRegistration);
    }

    // Dummy method to create a Saml2X509Credential
    private static Saml2X509Credential createDummyCredential() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
            String certString = "-----BEGIN CERTIFICATE-----\nMIICqDCCAZACCQDQa/BmDml9VjANBgkqhkiG9w0BAQUFADCBjzELMAkGA1UEBhMC\nVVMxCzAJBgNVBAgTAkNBMRAwDgYDVQQHEwdTYW5Kb3NlMRMwEQYDVQQKEwpFc2hh\nbm5lIERlbW8xEDAOBgNVBAsTB1Rlc3QgQ0ExEDAOBgNVBAMTB0V4YW1wbGUxHzAd\nBgkqhkiG9w0BCQEWEHRlc3RAZXhhbXBsZS5jb20wHhcNMTEwNzA2MjMwNzQ5WhcN\nMjEwNzA0MjMwNzQ5WjCBjzELMAkGA1UEBhMCVVMxCzAJBgNVBAgTAkNBMRAwDgYD\nVQQHEwdTYW5Kb3NlMRMwEQYDVQQKEwpFc2hhbm5lIERlbW8xEDAOBgNVBAsTB1Rl\nc3QgQ0ExEDAOBgNVBAMTB0V4YW1wbGUxHzAdBgkqhkiG9w0BCQEWEHRlc3RAZXhh\nbXBsZS5jb20wgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGBAK5AoXW7cTeNwG5D\nR5b9Z3vQm3Jg1oVt0nF6D8zYvJ4Xl5JIK9+zE+DfxiZ5kKZx2hY9mPR+0ErmVw2n\nq1JThD9rb7QZJ54p5e1c1v5fR7a+Bz8L5pHcA4oS6J7zN6lX1Cz8J/3J4sS9cOZF\n9iL5Xxgy8g+O0tIJ3G9h3bECAwEAATANBgkqhkiG9w0BAQUFAAOBgQCB8p9K8HaL\nu+2M+1a+3D9p0qk9VxJX8T8dFZV9A3XW/ZyyGJv6E+E6Wm9bTx5eFz6TxrP0fZ5z\nn2c4+5F5Z5d0c5d5c5t5Z5d5c5d5c5t5Z5d5c5d5z5d5c5d5c5d5c