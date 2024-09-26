import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestTemplateBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@SpringBootApplication
public class Temp1142 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1142.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private RestTemplate restTemplate;

    public String callService(String serviceId, String path) {
        ServiceInstance instance = loadBalancer.choose(serviceId);
        if (instance == null) {
            throw new IllegalStateException("No instances available for " + serviceId);
        }
        URI uri = UriComponentsBuilder.fromUri(instance.getUri()).path(path).build().toUri();
        return restTemplate.postForObject(uri, "Message", String.class);
    }
}