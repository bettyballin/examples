import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class CountryEnumApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountryEnumApplication.class, args);
    }
}

enum Country {
    USA,
    CANADA,
    MEXICO
}

@RestController
@RequestMapping("/api")
class CountryEnumController {

    @GetMapping("/countries")
    public List<String> getCountries() {
        return Arrays.stream(Country.values()).map(Enum::name).collect(Collectors.toList());
    }
}