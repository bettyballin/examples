import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class Temp2322 {
    public static void main(String[] args) {
        Temp2322 temp = new Temp2322();
        System.out.println(temp.getResult());
    }

    @Cacheable(value = "resultCache", key = "#authentication?.name")
    public String getResult() {
        return "Cached Result";
    }
}