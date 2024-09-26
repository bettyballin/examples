import org.springframework.security.access.prepost.PostAuthorize;

public class CarService {

    // Assuming CarDAO is an interface with a get method
    private CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @PostAuthorize("hasRole('ROLE_ADMIN') or returnObject.owner.id == authentication.principal.id")
    public Car getCar(int id) throws DAOException {
        return carDAO.get(id);
    }
}

// Assuming Car is a class with an 'owner' field of type 'User'
class Car {
    private User owner;
    // getters and setters
}

// Assuming User is a class with an 'id' field
class User {
    private String id;
    // getters and setters
}

// Assuming DAOException is an exception
class DAOException extends Exception {
    // constructor and methods
}

// Assuming CarDAO is an interface
interface CarDAO {
    Car get(int id) throws DAOException;
}