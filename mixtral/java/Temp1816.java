import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;

public class Temp1816 {
    public static void main(String[] args) {
        // Your main logic here
    }
}

@Repository
interface YourRepository {
    @Query("select count(e) from #{#entityName} e where e.user_id = ?#{principal?.id}")
    Long findCountByUserId();
}