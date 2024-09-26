import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

public class Temp162 {
    public static void main(String[] args) {
        // This is a placeholder for testing purposes
    }

    private static ArrayList<X509Certificate> parseCerts(String fileName, String pwd) throws Exception {
        ArrayList<X509Certificate> certsFromP12File = new ArrayList<>();
        String cmdLine = "/usr/bin/openssl pkcs12 -info -in " + fileName + " -clcerts -nokeys -passin pass:" + pwd;

        String line;

        Process p = Runtime.getRuntime().exec(cmdLine);

        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

        boolean readingCert = false;
        boolean gotCertToProcess = false;
        StringBuilder certString = new StringBuilder();

        while ((line = input.readLine()) != null) {
            if (line.contains("-----BEGIN CERTIFICATE-----")) {
                readingCert = true;
            }
            if (readingCert) {
                certString.append(line).append(System.getProperty("line.separator"));
            }
            if (line.contains("-----END CERTIFICATE-----")) {
                readingCert = false;
                gotCertToProcess = true;
            }
            if (gotCertToProcess) {
                X509Certificate cert = null;
                byte[] cert_bytes = certString.toString().getBytes();
                ByteArrayInputStream certInputStream = new ByteArrayInputStream(cert_bytes);
                cert = (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(certInputStream);
                certsFromP12File.add(cert);
                gotCertToProcess = false;
                certString = new StringBuilder();
            }
        }
        input.close();

        return certsFromP12File;
    }
}