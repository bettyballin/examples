import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.InputStream;
import java.util.Properties;

public class Temp1850 {

    public static void main(String[] args) {
        try {
            Session session = setUpSession("username", "password", "host", 22);
            Channel channel = session.openChannel("exec");

            // Extract the zip file
            ((ChannelExec) channel).setCommand("unzip /path/to/yourfile.zip -d /tmp/extracted_folder");
            channel.connect();
            readChannelOutput(channel);
            channel.disconnect();

            // Edit your text file
            channel = session.openChannel("exec");
            String commandToEditFile = "echo 'Your new content' > /tmp/extracted_folder/Test.txt";
            ((ChannelExec) channel).setCommand(commandToEditFile);
            channel.connect();
            readChannelOutput(channel);
            channel.disconnect();

            // Recompress the modified files back to a ZIP
            channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand("zip -r /path/to/newfile.zip /tmp/extracted_folder");
            channel.connect();
            readChannelOutput(channel);
            channel.disconnect();

            session.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Session setUpSession(String username, String password, String host, int port) throws Exception {
        JSch jsch = new JSch();
        Session session = jsch.getSession(username, host, port);
        session.setPassword(password);

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();

        return session;
    }

    public static void readChannelOutput(Channel channel) throws Exception {
        InputStream in = channel.getInputStream();
        byte[] tmp = new byte[1024];
        while (true) {
            while (in.available() > 0) {
                int i = in.read(tmp, 0, 1024);
                if (i < 0) break;
                System.out.print(new String(tmp, 0, i));
            }
            if (channel.isClosed()) {
                if (in.available() > 0) continue;
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ee) {
            }
        }
    }
}