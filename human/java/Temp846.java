import org.springframework.security.access.prepost.PreAuthorize;

public class Temp846 {
    public static void main(String[] args) {
        Temp846 temp = new Temp846();
        SomeEntity entity = new SomeEntity();
        temp.update(entity);
    }

    @PreAuthorize("hasPermission(#entity, 'ADMINISTRATION')")
    public SomeEntity update(SomeEntity entity) {
        // Implementation of the update method
        System.out.println("Update method called");
        return entity;
    }
}

class SomeEntity {
    // Fields and methods for SomeEntity
}