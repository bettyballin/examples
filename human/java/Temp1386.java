import org.apache.catalina.Context;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.apache.catalina.startup.Tomcat;

public class Main {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context ctx = tomcat.addWebapp("", System.getProperty("java.io.tmpdir"));

        UserDatabaseRealm realm = new UserDatabaseRealm();
        realm.setResourceName("UserDatabase");
        ctx.getParent().setRealm(realm);

        tomcat.start();
        tomcat.getServer().await();
    }
}