import jcifs.smb.SmbFile;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbSession;

public class Temp136 {
    public static void main(String[] args) {
        try {
            // Create a NtlmPasswordAuthentication object for authentication
            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, "username", "password");

            // Create a SmbFile object pointing to the share
            SmbFile share = new SmbFile("smb://server/share/", auth);

            // Perform an operation that requires authentication
            SmbFile newDir = new SmbFile(share, "newdir/");
            newDir.mkdir();

            // Close the session when done (not strictly necessary for jcifs)
            SmbSession.logoff(share.getURL(), auth);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}