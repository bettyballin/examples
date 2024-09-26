import org.springframework.security.access.prepost.PreAuthorize;

public class ProductService {

    @PreAuthorize("hasPermission(#user, 'cadastra_produto')")
    public void registerProduct(User user, Product product) {
        // Method implementation
    }
}