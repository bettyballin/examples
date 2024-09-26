import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
public class FooService {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Foo> findAll() {
        // Dummy implementation
        return new ArrayList<>();
    }
}

@RestController
@RequestMapping("/foos")
class FooController {

    private final FooService fooService;

    @Autowired
    public FooController(FooService fooService) {
        this.fooService = fooService;
    }

    @GetMapping
    public List<Foo> getAllFoos() {
        return fooService.findAll();
    }
}

class Foo {
    // Dummy class for demonstration purposes
    private String name;

    public Foo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}