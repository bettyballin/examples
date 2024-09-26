import javax.net.ssl.X509ExtendedKeyManager;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Date;

public class ReloadableX509KeyManager extends X509ExtendedKeyManager {
    private X509ExtendedKeyManager keyManager;

    public ReloadableX509KeyManager(X509ExtendedKeyManager keyManager) {
        this.keyManager = keyManager;
    }

    public void reload(X509ExtendedKeyManager keyManager) {
        this.keyManager = keyManager;
    }

    @Override
    public String[] getClientAliases(String keyType, Principal[] issuers) {
        return keyManager.getClientAliases(keyType, issuers);
    }

    @Override
    public String chooseClientAlias(String[] keyType, Principal[] issuers, java.net.Socket socket) {
        return keyManager.chooseClientAlias(keyType, issuers, socket);
    }

    @Override
    public String[] getServerAliases(String keyType, Principal[] issuers) {
        return keyManager.getServerAliases(keyType, issuers);
    }

    @Override
    public String chooseServerAlias(String keyType, Principal[] issuers, java.net.Socket socket) {
        return keyManager.chooseServerAlias(keyType, issuers, socket);
    }

    @Override
    public X509Certificate[] getCertificateChain(String alias) {
        return keyManager.getCertificateChain(alias);
    }

    @Override
    public PrivateKey getPrivateKey(String alias) {
        return keyManager.getPrivateKey(alias);
    }

    // Add any additional methods required for handling reloading of keys and certificates
    // For example, a method to check if the certificates are expired and reload them
    public boolean isCertificateExpired(String alias) {
        X509Certificate[] certificates = getCertificateChain(alias);
        if (certificates == null || certificates.length == 0) return true;
        for (X509Certificate cert : certificates) {
            if (cert.getNotAfter().before(new Date())) {
                return true;
            }
        }
        return false;
    }
}