import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyService {

    @Autowired
    private RestTemplate restTemplate;

    public Object getObject(String xyz) {
        Object result = restTemplate.getForObject("http://microserviceb/someresource/{xyz}", Object.class, xyz);
        return result;
    }
}