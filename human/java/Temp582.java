import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class Temp582Service {

    @PreAuthorize("hasPermission(#project, 'read')")
    public void execute(String project) {
        System.out.println("Access granted to read the project: " + project);
    }
}

public class Temp582 {
    public static void main(String[] args) {
        Temp582Service service = new Temp582Service();
        service.execute("exampleProject");
    }
}