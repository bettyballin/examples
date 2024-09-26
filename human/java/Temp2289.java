import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Base64;

public class ImportPrivateKey {
    public static void main(String[] args) throws Exception {
        if (args.length != 10) {
            System.out.println("Usage: java ImportPrivateKey -keystore <keystore> -storepass <storepass> -storetype <storetype> -keypass <keypass> -alias <alias> -certfile <certfile> -keyfile <keyfile> -keyfilepass <keyfilepass>");
            return;
        }

        String keystoreFile = args[1];
        String storepass = args[3];
        String storetype = args[5];
        String keypass = args[7];
        String alias = args[9];
        String certfile = args[11];
        String keyfile = args[13];
        String keyfilepass = args[15];

        KeyStore keystore = KeyStore.getInstance(storetype);
        keystore.load(null, storepass.toCharArray());

        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        FileInputStream certFileInputStream = new FileInputStream(certfile);
        Certificate certificate = certFactory.generateCertificate(certFileInputStream);
        certFileInputStream.close();

        FileInputStream keyFileInputStream = new FileInputStream(keyfile);
        byte[] keyBytes = new byte[keyFileInputStream.available()];
        keyFileInputStream.read(keyBytes);
        keyFileInputStream.close();

        String keyString = new String(keyBytes);
        keyString = keyString.replaceAll("-----BEGIN PRIVATE KEY-----", "").replaceAll("-----END PRIVATE KEY-----", "").replaceAll("\\s+", "");
        byte[] decodedKey = Base64.getDecoder().decode(keyString);
        PrivateKey privateKey = KeyStore.PrivateKeyEntry.class.getDeclaredConstructor(byte[].class).newInstance(decodedKey);

        Certificate[] chain = new Certificate[1];
        chain[0] = certificate;

        keystore.setKeyEntry(alias, privateKey, keypass.toCharArray(), chain);

        FileOutputStream keystoreOutputStream = new FileOutputStream(keystoreFile);
        keystore.store(keystoreOutputStream, storepass.toCharArray());
        keystoreOutputStream.close();

        System.out.println("Private key and certificate imported successfully.");
    }
}