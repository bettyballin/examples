public class Temp1101 {

    // Dummy annotation to simulate @Secured
    public @interface Secured {
        String value();
    }

    // Dummy interface to simulate FlightSpotting
    public interface FlightSpotting {
        // Add methods as needed
    }

    // Dummy class to simulate FlightSpotting implementation
    public static class FlightSpottingImpl implements FlightSpotting {
        // Implement methods as needed
    }

    @Secured("GetByOwner")
    public static FlightSpotting getFlightSpotting(Long id) {
        // Replace with actual logic
        return new FlightSpottingImpl();
    }

    public static void main(String[] args) {
        FlightSpotting flightSpotting = getFlightSpotting(1L);
        // Perform operations with flightSpotting
        System.out.println("FlightSpotting object retrieved: " + flightSpotting);
    }
}