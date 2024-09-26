import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.*;
import java.util.Base64;

public class OCSPChecker {

    /**
     * This is a class that checks the revocation status of a certificate(s) using
     * OCSP. It is not a PKIXCertPathChecker and therefore can be used outside of
     * the CertPathValidator framework. It is useful when you want to
     * just check the revocation status of a certificate, and you don't want to
     * incur the overhead of validating all of the certificates in the
     * associated certificate chain.
     *
     * @author Sean Mullan
     */

    // Your OCSP URL
    private static final String OCSP_URL = "http://ocsp.example.com";

    public static void main(String[] args) {
        try {
            // Load the certificate
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(
                OCSPChecker.class.getResourceAsStream("/path/to/certificate.crt"));

            // Check the revocation status
            boolean isRevoked = checkRevocationStatus(cert);
            System.out.println("Certificate revoked: " + isRevoked);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkRevocationStatus(X509Certificate cert) throws Exception {
        // Generate OCSP request
        byte[] ocspRequest = generateOCSPRequest(cert);

        // Send OCSP request and get the response
        HttpURLConnection con = (HttpURLConnection) new URL(OCSP_URL).openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/ocsp-request");
        con.setDoOutput(true);
        con.getOutputStream().write(ocspRequest);

        // Parse OCSP response
        OCSPResp ocspResponse = new OCSPResp(con.getInputStream());
        return parseOCSPResponse(ocspResponse);
    }

    private static byte[] generateOCSPRequest(X509Certificate cert) throws Exception {
        // Create OCSP request
        CertificateID certId = new CertificateID(CertificateID.HASH_SHA1, cert, cert.getSerialNumber());
        OCSPReqBuilder reqBuilder = new OCSPReqBuilder();
        reqBuilder.addRequest(certId);
        OCSPReq ocspReq = reqBuilder.build();
        return ocspReq.getEncoded();
    }

    private static boolean parseOCSPResponse(OCSPResp ocspResponse) throws Exception {
        if (ocspResponse.getStatus() != OCSPResp.SUCCESSFUL) {
            throw new Exception("OCSP request not successful");
        }

        BasicOCSPResp basicResponse = (BasicOCSPResp) ocspResponse.getResponseObject();
        SingleResp[] responses = (SingleResp[]) basicResponse.getResponses();
        for (SingleResp resp : responses) {
            Object certStatus = resp.getCertStatus();
            if (certStatus == CertificateStatus.GOOD) {
                return false;
            } else if (certStatus instanceof RevokedStatus) {
                return true;
            }
        }
        return false;
    }
}