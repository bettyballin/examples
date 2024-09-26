import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final ColorService colorService;
    private final CarRepository carRepository;

    @Autowired
    public CarService(ColorService colorService, CarRepository carRepository) {
        this.colorService = colorService;
        this.carRepository = carRepository;
    }

    @PreAuthorize("someCheck(#carId)")
    public List<String> getCarColors(String carId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return getCar(carId).getColors().parallelStream()
            .map(color -> {
                // Propagate the security context
                SecurityContextHolderUtil.setAuthentication(auth);
                String colorName = colorService.getColor(color.getId());
                // Clear the propagated authentication after use
                SecurityContextHolderUtil.clearContext();
                return colorName;
             })
            .collect(Collectors.toList());
    }

    private Car getCar(String carId) {
        return carRepository.findById(carId).orElseThrow(() -> new RuntimeException("Car not found"));
    }
}

// Assuming you have classes like these:
class ColorService {
    public String getColor(String colorId) {
        // Dummy implementation
        return "ColorName";
    }
}

class Car {
    private List<Color> colors;

    public List<Color> getColors() {
        return colors;
    }

    // Other properties and methods
}

class Color {
    private String id;

    public String getId() {
        return id;
    }

    // Other properties and methods
}

class CarRepository {
    public java.util.Optional<Car> findById(String carId) {
        // Dummy implementation
        return java.util.Optional.of(new Car());
    }
}

class SecurityContextHolderUtil {
    public static void setAuthentication(Authentication auth) {
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    public static void clearContext() {
        SecurityContextHolder.clearContext();
    }
}