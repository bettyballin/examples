import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Temp2404 implements CommandLineRunner {

    private final MeccanicoRepository meccanicoRepo;
    private final InterventoRepository interventoRepo;

    @Autowired
    public Temp2404(MeccanicoRepository meccanicoRepo, InterventoRepository interventoRepo) {
        this.meccanicoRepo = meccanicoRepo;
        this.interventoRepo = interventoRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(Temp2404.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Your logic here
    }
}

interface MeccanicoRepository {
    // Define repository methods
}

interface InterventoRepository {
    // Define repository methods
}