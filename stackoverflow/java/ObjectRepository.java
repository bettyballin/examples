public interface ObjectRepository<T extends DomainObject> {
    T save(T object);
    // ...
}