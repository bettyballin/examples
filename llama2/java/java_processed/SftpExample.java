import com.jcraft.jsch.*;

public class SftpExample {
  public static void main(String[] args) throws Exception {
    // Set up the connection
    JSch jsch = new JSch();
    Session session = jsch.getSession("username", "host", 22);
    session.setPassword("password");

    // Avoid asking for key confirmation
    java.util.Properties config = new java.util.Properties();
    config.put("StrictHostKeyChecking", "no");
    session.setConfig(config);

    // Connect to the server
    session.connect();

    // Change to the directory containing the file you want
    Channel channel = session.openChannel("sftp");
    channel.connect();
    ChannelSftp sftpChannel = (ChannelSftp) channel;
    sftpChannel.put("C:\\path\\to\\local\\file", "remote/path/to/file");

    // Disconnect from the server
    sftpChannel.exit();
    session.disconnect();
  }
}