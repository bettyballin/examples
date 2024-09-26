import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class FileTransfer {
    public static void main(String[] args) {
        String host = "your_host";
        int port = 22;
        String username = "your_username";
        String password = "your_password";
        String remoteFilePath = "/path/to/remote/file";
        String localFilePath = "/path/to/local/file";

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(username, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
            channel.connect();
            
            channel.get(remoteFilePath, localFilePath);
            
            channel.disconnect();
            session.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}