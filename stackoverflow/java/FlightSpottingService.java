import org.springframework.security.access.annotation.Secured;

public interface FlightSpottingService {

    @Secured("GetByOwner")
    FlightSpotting getFlightSpotting(Long id);
}

class FlightSpotting {
    // FlightSpotting class implementation
}