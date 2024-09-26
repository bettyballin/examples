import javax.net.ssl.X509KeyManager;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.HashMap;

public class MyX509KeyManager implements X509KeyManager {

    private final X509KeyManager defaultKeyManager;
    private final Map<String, X509Certificate[]> certificates = new HashMap<>();
    private final Map<String, PrivateKey> privateKeys = new HashMap<>();

    public MyX509KeyManager(X509KeyManager defaultKeyManager) {
        this.defaultKeyManager = defaultKeyManager;
    }

    public void addCertificate(String alias, X509Certificate[] chain, PrivateKey key) {
        certificates.put(alias, chain);
        privateKeys.put(alias, key);
    }

    @Override
    public String[] getClientAliases(String keyType, Principal[] issuers) {
        return defaultKeyManager.getClientAliases(keyType, issuers);
    }

    @Override
    public String chooseClientAlias(String[] keyType, Principal[] issuers, Socket socket) {
        return defaultKeyManager.chooseClientAlias(keyType, issuers, socket);
    }

    @Override
    public String[] getServerAliases(String keyType, Principal[] issuers) {
        return defaultKeyManager.getServerAliases(keyType, issuers);
    }

    @Override
    public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket) {
        return defaultKeyManager.chooseServerAlias(keyType, issuers, socket);
    }

    @Override
    public X509Certificate[] getCertificateChain(String alias) {
        return certificates.get(alias);
    }

    @Override
    public PrivateKey getPrivateKey(String alias) {
        return privateKeys.get(alias);
    }
}