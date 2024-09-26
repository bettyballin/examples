import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// Assuming IpRestricted is a valid custom annotation you have in your codebase.
import your.package.annotation.IpRestricted;

@RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
@ResponseBody
@IpRestricted
public void download(@PathVariable("id") String id) {
   // ...
}