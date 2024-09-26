import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.io.*;
import java.net.*;

public class Server {

    private static final int SOCKET_PORT = 13267; // Example port number
    private static final String FILE_TO_SEND = "path/to/your/file.txt"; // Example file path

    public static void main(String[] args) {
        try {
            ServerSocket servsock = new ServerSocket(SOCKET_PORT);
            System.out.println("Waiting...");

            while (true) {
                Socket sock = servsock.accept();
                System.out.println("Accepted connection : " + sock);

                File myFile = new File(FILE_TO_SEND);
                byte[] fileBytes = new byte[(int) myFile.length()];
                FileInputStream fis = new FileInputStream(myFile);
                BufferedInputStream bis = new BufferedInputStream(fis);
                OutputStream os = sock.getOutputStream();

                int bytesRead;
                while ((bytesRead = bis.read(fileBytes)) != -1) {
                    os.write(fileBytes, 0, bytesRead);
                }

                os.flush();
                bis.close();
                sock.close();
                System.out.println("File sent successfully!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}