import java.util.Hashtable;

public class Main10 {
    public static void main(String[] args) {
        Hashtable<String, String> env = new Hashtable<>();
        env.put("java.naming.ldap.factory.socket", "com.example.MySSLSocketFactory");
        // Rest of the code that uses env...
    }
}