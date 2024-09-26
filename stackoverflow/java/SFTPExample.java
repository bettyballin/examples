import com.jcraft.jsch.*;

public class SFTPExample {
    public static void main(String[] arg) {
        try {
            JSch jsch = new JSch();

            String knownHostsFilename = "/home/username/.ssh/known_hosts";
            jsch.setKnownHosts(knownHostsFilename);

            Session session = jsch.getSession("remote-username", "remote-host");
            UserInfo ui = new MyUserInfo(); // Ensure MyUserInfo implements UserInfo
            session.setUserInfo(ui);

            session.setPassword("remote-password");

            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();

            ChannelSftp sftpChannel = (ChannelSftp) channel;

            sftpChannel.get("remote-file", "local-file");

            InputStream in = sftpChannel.get("remote-file");
            // process inputstream as needed

            sftpChannel.exit();
            session.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class MyUserInfo implements UserInfo {
        public String getPassword() { return "password"; }
        public boolean promptYesNo(String str) { return true; }
        public String getPassphrase() { return null; }
        public boolean promptPassphrase(String message) { return true; }
        public boolean promptPassword(String message) { return true; }
        public void showMessage(String message) {}
    }
}