import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.mindrot.jbcrypt.BCrypt;

public class Temp963 {
    public static void main(String[] args) {
        String plainTextPassword = "yourPlainTextPassword";
        String hashedPassword = BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Future<Boolean> result1 = executor.submit(() -> BCrypt.checkpw(plainTextPassword, hashedPassword));
        
        try {
            System.out.println("Password match: " + result1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
    }
}