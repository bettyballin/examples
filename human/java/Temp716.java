import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.FileInputStream;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class Temp716 {
    public static void main(String[] args) {
        try {
            String toVerify = "A1005056807CE11EE2B4CE0025305725CFrCN%3DKED,OU%3DI0020266601,OU%3DSAPWebAS,O%3DSAPTrustCommunity,C%3DDE20130611102236";
            String signed = "MIIBUQYJKoZIhvcNAQcCoIIBQjCCAT4CAQExCzAJBgUrDgMCGgUAMAsGCSqGSIb3DQEHATGCAR0wggEZAgEBMG8wZDELMAkGA1UEBhMCREUxHDAaBgNVBAoTE1NBUCBUcnVzdCBDb21tdW5pdHkxEzARBgNVBAsTClNBUCBXZWIgQVMxFDASBgNVBAsTC0kwMDIwMjY2NjAxMQwwCgYDVQQDEwNLRUQCByASEgITMlYwCQYFKw4DAhoFAKBdMBgGCSqGSIb3DQEJAzELBgkqhkiG9w0BBwEwHAYJKoZIhvcNAQkFMQ8XDTEzMDYxMTA4MjM1MVowIwYJKoZIhvcNAQkEMRYEFGy7jXb/pUqMYdk2dss2Qe6hNroaMAkGByqGSM44BAMELjAsAhRMJ+t5/3RxQAsHKnIoPY4BnO0qCAIUAbKRwWNjOYsewB56zoZqnZwRyWw=";
            byte[] signedByte = Base64.getDecoder().decode(signed);

            Security.addProvider(new BouncyCastleProvider());

            CMSSignedData s = new CMSSignedData(new CMSProcessableByteArray(toVerify.getBytes()), signedByte);
            SignerInformationStore signers = s.getSignerInfos();
            SignerInformation signerInfo = signers.getSigners().iterator().next();

            FileInputStream fis = new FileInputStream("c:\\sap.cer");
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificates(fis).iterator().next();

            boolean result = signerInfo.verify(new JcaSimpleSignerInfoVerifierBuilder().setProvider("BC").build(cert.getPublicKey()));
            System.out.println("Verified: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}