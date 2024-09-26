import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface SecureValidation {
    Class<?> entityClass();
}

@RestController
public class MyController {

    @Autowired
    private ThingService thingService;

    @GetMapping("/things/{thingId}")
    @SecureValidation(entityClass = Thing.class)
    public ResponseEntity<Thing> getThing(@PathVariable Long thingId) {
        Thing thing = thingService.getThingById(thingId);
        return ResponseEntity.ok(thing);
    }
}

class Thing {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

@Service
class ThingService {
    public Thing getThingById(Long id) {
        Thing thing = new Thing();
        thing.setId(id);
        thing.setName("Sample Thing");
        return thing;
    }
}