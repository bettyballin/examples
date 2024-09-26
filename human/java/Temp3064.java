import java.awt.Color;
import java.util.concurrent.CompletableFuture;

public class Temp3064 {

    public static void main(String[] args) {
        Temp3064 temp = new Temp3064();
        temp.getColor("RED").thenAccept(color -> {
            System.out.println("Color: " + color);
        });
    }

    public CompletableFuture<Color> getColor(String colorId) {
        return CompletableFuture.supplyAsync(() -> {
            switch (colorId.toUpperCase()) {
                case "RED":
                    return Color.RED;
                case "GREEN":
                    return Color.GREEN;
                case "BLUE":
                    return Color.BLUE;
                default:
                    return Color.BLACK;
            }
        });
    }
}