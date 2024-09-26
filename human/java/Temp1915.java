import java.io.File;
import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.auth.pubkey.AuthorizedKeysAuthenticator;

public class Temp1915 {
    private SshServer sshServer;

    public Temp1915() {
        this.sshServer = SshServer.setUpDefaultServer();
    }

    public void setupServer() {
        this.sshServer.setPublickeyAuthenticator(
            new AuthorizedKeysAuthenticator(new File("id_rsa.pub"))
        );
    }

    public static void main(String[] args) {
        Temp1915 temp1915 = new Temp1915();
        temp1915.setupServer();
        System.out.println("SSH Server public key authenticator set up with id_rsa.pub");
    }
}