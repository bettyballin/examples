import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Temp830 {
    private ConcurrentMap<String, Integer> sessionQueriesCount = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Temp830 temp = new Temp830();
        // Example usage:
        temp.sessionQueriesCount.put("session1", 1);
        System.out.println(temp.sessionQueriesCount.get("session1"));
    }
}