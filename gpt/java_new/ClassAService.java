import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassAService {

    private final ClassARepository classARepository;
    private final ClassBRepository classBRepository;

    @Autowired
    public ClassAService(ClassARepository classARepository, ClassBRepository classBRepository) {
        this.classARepository = classARepository;
        this.classBRepository = classBRepository;
    }

    // Other methods using classARepository and classBRepository
}