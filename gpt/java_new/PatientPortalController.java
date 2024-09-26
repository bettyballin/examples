import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/patientportals")
public class PatientPortalController {

    private final String baseURL = "http://example.com/api/patientportals";
    private final RestTemplate restTemplate;

    @Autowired
    public PatientPortalController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientPortalById(@PathVariable("id") Long id) {
        try {
            return restTemplate.getForEntity(baseURL + "/" + id, PatientPortal.class);
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getStatusText());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatientPortal(@PathVariable("id") Long id, @RequestBody PatientPortal patientPortal) {
        try {
            restTemplate.put(baseURL + "/" + id, patientPortal);
            return ResponseEntity.ok().build();
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getStatusText());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatientPortal(@PathVariable("id") Long id) {
        try {
            restTemplate.delete(baseURL + "/" + id);
            return ResponseEntity.ok().build();
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getStatusText());
        }
    }
}