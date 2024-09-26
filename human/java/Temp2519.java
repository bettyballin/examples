import java.io.Serializable;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.access.prepost.PreAuthorize;

public class Temp2519 {
    public static void main(String[] args) {
        // Main method content
    }
}

@NoRepositoryBean // tell Spring not create instances of this one
@PreAuthorize("hasRole('ROLE_ADMIN')") // all methods will inherit this behavior
interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {}