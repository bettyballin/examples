import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

public class MyService1 {

    // Assuming MyItem is a valid class and dao is a variable already defined and properly instantiated

    @PostAuthorize("hasPermission(returnObject, 'READ')")
    public MyItem getMyItem(Long id) {
        return dao.getMyItem(id);
    }

    @PreAuthorize("hasPermission(#toDelete, 'DELETE')")
    public void deleteMyItem(MyItem toDelete) {
        dao.delete(toDelete);
    }

    // Other necessary class details
}