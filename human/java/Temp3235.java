import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertPath;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.zip.ZipFile;
import jdk.security.jarsigner.JarSigner;

class JarSignerDemo {
  public static void main(String[] args) throws IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
    char[] password = "changeit".toCharArray();
    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    keyStore.load(new java.io.FileInputStream(new File("keystore.jks")), password);
    PrivateKey privateKey = (PrivateKey) keyStore.getKey("mykey", password);
    CertPath certPath = CertificateFactory.getInstance("X.509").generateCertPath(Arrays.asList(keyStore.getCertificateChain("mykey")));
    JarSigner jarSigner = new JarSigner.Builder(privateKey, certPath)
      .digestAlgorithm("SHA-256")
      .signatureAlgorithm("RSASSA-PSS")
      .build();
    try (
      ZipFile jarFile = new ZipFile("my.jar");
      FileOutputStream signedJarFile = new FileOutputStream("my-signed.jar")
    )
    {
      jarSigner.sign(jarFile, signedJarFile);
    }
  }
}