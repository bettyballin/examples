import java.net.SocketPermission;

public class Main33 {
    public static void main(String[] args) {
        SocketPermission sp = new SocketPermission("puffin.eng.sun.com:7777", "connect,accept");
    }
}