import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("team.xuli.toe.dao")
public class ToeServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToeServerApplication.class, args);
    }
}