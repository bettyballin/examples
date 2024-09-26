import java.io.IOException;
import java.net.URL;
import java.security.CodeSource;
import java.security.Policy;

public class Main41 {
  public static void main(String[] args) {

    CodeSource source;

    try {
      source = new CodeSource(new URL("file:/c:/"), (java.security.cert.Certificate[]) null);

      Policy policy = Policy.getPolicy();
      System.out.println(policy.getPermissions(source));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}