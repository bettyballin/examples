import java.util.HashMap;
import java.util.Map;

public class Temp2436 {
    public static void main(String[] args) {
        Map<String, String> result = new HashMap<>();
        result.put("name", "John Doe");
        result.put("acct", "123456");
        result.put("amt", "1000");

        String name = result.get("name");
        String acct = result.get("acct");
        String amt = result.get("amt");
        String query = "insert into payment_process (name,acct,amt) values('" + name + "','" + acct + "','" + amt + "')";

        System.out.println(query);
    }
}