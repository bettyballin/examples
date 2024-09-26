import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.io.Serializable;

@NoRepositoryBean
@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
}