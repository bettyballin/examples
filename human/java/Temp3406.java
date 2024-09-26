import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Temp3406 {

    public static void main(String[] args) {
        Temp3406 temp = new Temp3406();
        temp.getResult();
    }

    @Cacheable(value = "resultCache", key = "T(org.springframework.security.core.context.SecurityContextHolder).getContext()?.getAuthentication()?.getName()")
    public String getResult() {
        return "Result";
    }
}