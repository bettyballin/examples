import java.security.PrivateKey;
import java.util.Collection;
import java.util.Iterator;
import org.bouncycastle.cms.CMSEnvelopedDataParser;
import org.bouncycastle.cms.RecipientInformation;
import org.bouncycastle.cms.RecipientInformationStore;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp2169 {
    public static void main(String[] args) {
        // Example usage (you need to provide actual message and key)
        // byte[] message = ...;
        // PrivateKey key = ...;
        // try {
        //     byte[] decryptedMessage = cmsDecrypt(message, key);
        //     System.out.println(new String(decryptedMessage));
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }

    private static byte[] cmsDecrypt(byte[] message, PrivateKey key) throws Exception {
        CMSEnvelopedDataParser ep = new CMSEnvelopedDataParser(message);
        RecipientInformationStore recipients = ep.getRecipientInfos();
        Collection<?> c = recipients.getRecipients();
        Iterator<?> iter = c.iterator();
        RecipientInformation recipient = (RecipientInformation) iter.next();
        return recipient.getContent(key, new BouncyCastleProvider());
    }
}