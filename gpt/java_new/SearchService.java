import org.springframework.security.access.prepost.PreAuthorize;

public class SearchService {

    @PreAuthorize("hasAuthority('EXECUTE_SEARCH')")
    public void executeSearch() {
        // method implementation
    }
}