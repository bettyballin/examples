import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.ibm.websphere.ssl.SSLConfig;

public class Temp101 {
    public static void main(String[] args) {
        try {
            // Load the certificate from a file
            InputStream certStream = new FileInputStream("path/to/certificate.cer");

            // Create an SSLContext instance
            SSLContext sslContext = SSLContext.getInstance("TLS");

            // Initialize the SSLContext with the certificate
            sslContext.init(null, new TrustManager[] {
                new X509TrustManager() {
                    public void checkClientTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) {}

                    public void checkServerTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) {
                        // Add the certificate to the truststore
                        try {
                            SSLConfig.getSSLConfig().getNodeDefaultTrustStore().addCertificate(x509Certificates[0]);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return new java.security.cert.X509Certificate[0];
                    }
                }
            }, null);

            // Use the SSLContext to create an SSLEngine
            SSLEngine engine = sslContext.createSSLEngine();

            // ... use the engine
            System.out.println("SSLEngine created successfully.");
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}