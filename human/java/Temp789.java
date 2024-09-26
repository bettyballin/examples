import java.net.SocketPermission;

public class Temp789 {
    public static void main(String[] args) {
        SocketPermission permission = new SocketPermission("puffin.eng.sun.com:7777", "connect,accept");
        System.out.println("SocketPermission created: " + permission);
    }
}