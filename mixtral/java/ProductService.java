import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    // Placeholder for actual product repository
    // private final ProductRepository productRepository;

    // Constructor injection if a repository is used
    // public ProductService(ProductRepository productRepository) {
    //     this.productRepository = productRepository;
    // }

    @PreAuthorize("hasRole('ROLE_USER') and #product.userId == principal.id")
    public void updateProduct(Product product) {
        // Update logic
        // productRepository.save(product);
        System.out.println("Product updated: " + product);
    }

    public static void main(String[] args) {
        // Example usage
        ProductService productService = new ProductService();
        Product product = new Product(1, 1, "Sample Product");
        productService.updateProduct(product);
    }
}

class Product {
    private int id;
    private int userId;
    private String name;

    public Product(int id, int userId, String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", userId=" + userId + ", name='" + name + "'}";
    }
}