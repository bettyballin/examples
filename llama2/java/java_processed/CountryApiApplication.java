import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CountryApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CountryApiApplication.class, args);
    }
}

@RestController
class CountryApi {
    @GetMapping("/countries")
    public List<Country> getCountries() {
        return Arrays.asList(Country.values());
    }
}

enum Country {
    USA, CANADA, MEXICO, BRAZIL, ARGENTINA, FRANCE, GERMANY, ITALY, SPAIN, UK
}