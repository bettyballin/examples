import org.bouncycastle.asn1.*;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;

import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class Temp137 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());

        // Example Base64 encoded PKCS#10 Certificate Signing Request (CSR)
        String csrPEM = "-----BEGIN CERTIFICATE REQUEST-----\n" +
                "MIICzDCCAbQCAQAwgYsxCzAJBgNVBAYTAklOMQswCQYDVQQIDAJLUjELMAkGA1UE\n" +
                "BwwCU1MxCzAJBgNVBAoMAlRUMQswCQYDVQQLDAJJVDEgMB4GA1UEAwwXbG9jYWxo\n" +
                "b3N0LmxvY2FsZG9tYWluLmNvbTEgMB4GCSqGSIb3DQEJARYRdGVzdEBleGFtcGxl\n" +
                "LmNvbTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAL6YlWJmF0u8EwS7\n" +
                "K0V2XQhTgG8QpU5jT9nZ8ZQ9yqfYy8l3X1eFzYqFhYl3jOQldI1bqz4l5+f9Xh+q\n" +
                "5k3e0QeD0qQGKhBfj2fI8uUddm5cAG+oYj2zH0Q1m8R1A0/yNm7xY2NH5QZy1Yb0\n" +
                "4e/2QZ6A8dXGH5V5DR5dK9t0SiT9t3/8rjWvH2Q5e2bZk5KZb8YhcQYhWj2eeRk+\n" +
                "7tthKpG0F3TG+eQXvLw2V1rsw5zU2VYqZ5bka2l6B4Ay9yYB4pVw+Q2F3m9Z5D4p\n" +
                "7U2zP2p1xj5vD1VniMv8e5z5jLkZQzqUMjF5g2y9I7x7F3LZ5Yy7xX9y5Wl+T9J7\n" +
                "M0OZp8zT2sECAwEAAaAAMA0GCSqGSIb3DQEBCwUAA4IBAQA1Xv4Fj0Ao3lH6i2mI\n" +
                "8G4zj8wzj8j4Xy4jdgyw3f0Y9Y8Mx5aJcXr8gRnfM7RV3eGg5dA9rjv1gbTlC7dM\n" +
                "6wY8bAXFzXw5G8z/3k8yX/1wX7Yckv/yzf0a4Zf5c5xU8FQ9O1I5c6G+YJtQ+0zU\n" +
                "vJp9Si2F7d4cWxXbcdBeRh2VQ5yT5f2Q+0j4z8yP8Tjndh8O8z3XWf3q5v5ExmYV\n" +
                "1QJ7vG2uO+8Vh8z8QO8z3Q8z3Q5c4j8xU8FQ9yT5f2Q+0j5f2Q+0j8z8xU