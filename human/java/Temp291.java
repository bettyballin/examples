public interface DomainObject {
    // Define any necessary methods for DomainObject here
    // For example, a method to get the ID of the object
    Long getId();
}

public interface ObjectRepository<T extends DomainObject> {
    public T save(T object);
    // You can define other methods here
    // For example, methods to find, delete, or update objects
    public T find(Long id);
    public void delete(Long id);
    // Any other methods needed for the repository
}

public class ExampleDomainObject implements DomainObject {
    private Long id;
    private String name;

    public ExampleDomainObject(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class ExampleObjectRepository implements ObjectRepository<ExampleDomainObject> {
    // For simplicity, use a map to store objects in memory
    private Map<Long, ExampleDomainObject> storage = new HashMap<>();

    @Override
    public ExampleDomainObject save(ExampleDomainObject object) {
        storage.put(object.getId(), object);
        return object;
    }

    @Override
    public ExampleDomainObject find(Long id) {
        return storage.get(id);
    }

    @Override
    public void delete(Long id) {
        storage.remove(id);
    }
    
    // You can add other methods as necessary
}

public class Main {
    public static void main(String[] args) {
        ExampleObjectRepository repository = new ExampleObjectRepository();
        ExampleDomainObject obj1 = new ExampleDomainObject(1L, "Object 1");
        ExampleDomainObject obj2 = new ExampleDomainObject(2L, "Object 2");

        repository.save(obj1);
        repository.save(obj2);

        System.out.println(repository.find(1L).getName()); // Output: Object 1
        System.out.println(repository.find(2L).getName()); // Output: Object 2

        repository.delete(1L);

        System.out.println(repository.find(1L)); // Output: null
    }
}