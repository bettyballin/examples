import com.google.gson.Gson;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp1120 {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String authoritiesJson = gson.toJson(new String[]{SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString()});
        System.out.println(authoritiesJson);
    }
}