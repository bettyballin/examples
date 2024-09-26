import com.google.gson.Gson;
import org.springframework.security.core.context.SecurityContextHolder;

public class MyClass4 {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String json = gson.toJson(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray());
        System.out.println(json);
    }
}