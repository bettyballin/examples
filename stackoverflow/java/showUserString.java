import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/showUserString", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public String showUserString() {
    // Your implementation here
    return "{\"user\":\"John Doe\"}";
}