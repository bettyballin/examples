import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

@Service
public class CarService {

    private final Executor asyncExecutor;

    @Autowired
    public CarService(Executor asyncExecutor) {
        this.asyncExecutor = asyncExecutor;
    }

    @PreAuthorize("someCheck(#carId)")
    public List<String> getCarColors(String carId) throws InterruptedException, ExecutionException {
        // Implementation goes here
        return null;
    }
}