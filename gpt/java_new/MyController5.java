import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController5 {
  
  @PreAuthorize("hasAuthority('SCOPE_read')")
  @GetMapping("/read-data")
  public String readData() {
    return "data";
  }

  @PreAuthorize("hasAuthority('SCOPE_write')")
  @GetMapping("/write-data")
  public String writeData() {
    return "write complete";
  }
}