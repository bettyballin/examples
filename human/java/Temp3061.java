import java.util.concurrent.CompletableFuture;
import java.awt.Color;

public class Temp3061 {

    // Assuming you have a ColorRepository interface
    interface ColorRepository {
        Color findById(String colorId);
    }

    // Create an instance of ColorRepository for demonstration
    static class DummyColorRepository implements ColorRepository {
        @Override
        public Color findById(String colorId) {
            // Dummy implementation, replace with actual logic to find color by ID
            return Color.RED; // Example color
        }
    }

    private final ColorRepository colorRepository = new DummyColorRepository();

    public static void main(String[] args) {
        Temp3061 temp = new Temp3061();
        temp.getColor("someColorId").thenAccept(color -> {
            System.out.println("Color: " + color);
        });
    }

    @org.springframework.scheduling.annotation.Async
    public CompletableFuture<Color> getColor(String colorId) {
        return CompletableFuture.completedFuture(this.colorRepository.findById(colorId));
    }
}