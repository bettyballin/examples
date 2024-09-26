import java.util.List;

public interface CarService {
    List<Car> getCars() throws DAOException;
}

@Service
class DefaultCarService implements CarService {

    private final CarDAO carDAO;

    public DefaultCarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @PostFilter("hasRole('ROLE_ADMIN') or filterObject.getDrivers().stream().anyMatch(driver -> driver.getId() == principal.getId())")
    public List<Car> getCars() throws DAOException {
        return carDAO.getAll();
    }
}

interface CarDAO {
    List<Car> getAll() throws DAOException;
}

class DAOException extends Exception {
    public DAOException(String message) {
        super(message);
    }
}

class Car {
    private List<Driver> drivers;

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}

class Driver {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}