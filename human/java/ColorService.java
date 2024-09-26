import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

@Service
public class ColorService {
    @Resource
    private ColorService self;

    public Collection<Color> getCarColors(String carId) {
        Queue<Color> colors = new ConcurrentLinkedQueue<>();

        this.getCar(carId)
            .getColors()
            .stream()
            .map(colorId -> self.getColor(colorId)
                                .thenAccept(colors::add))
            .collect(Collectors.collectingAndThen(Collectors.toList(), CompletableFuture::allOf))
            .join();

        return colors;
    }

    // Mock methods for demonstration purposes
    private Car getCar(String carId) {
        // Dummy implementation
        return new Car();
    }

    private CompletableFuture<Color> getColor(String colorId) {
        // Dummy implementation
        return CompletableFuture.completedFuture(new Color());
    }

    // Dummy Car and Color classes for demonstration purposes
    class Car {
        public Collection<String> getColors() {
            // Dummy implementation
            return List.of("colorId1", "colorId2");
        }
    }

    class Color {
        // Dummy implementation
    }
}