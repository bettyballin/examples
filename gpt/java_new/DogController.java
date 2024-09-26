import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "dogs", path = "dogs")
public interface DogRepository extends MongoRepository<Dog, ObjectId> {

    @Query("{ 'owner' : ?#{principal.username} }")
    List<Dog> findByOwner();
}

@RestController
@RequestMapping("/dogs")
public class DogController {

    private final DogRepository dogRepository;

    public DogController(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }
    
    // Add additional methods and annotations to use the DogRepository
}