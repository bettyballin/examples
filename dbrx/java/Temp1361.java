import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class Temp1361 {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Temp1361.class, args);
    }

    @PostMapping("/calculate")
    public ResponseEntity<String> calculate(@RequestBody CalculationRequest request) {
        // Perform initial processing and send an immediate response.
        String dummyResponse = "Processing started...";
        return ResponseEntity.ok(dummyResponse);
    }

}

class CalculationRequest {
    // Define fields and methods for CalculationRequest
}


becomes


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class Temp1361 {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Temp1361.class, args);
    }

    @PostMapping("/calculate")
    public ResponseEntity<String> calculate(@RequestBody CalculationRequest request) {
        // Perform initial processing and send an immediate response.
        String dummyResponse = "Processing started...";
        return ResponseEntity.ok(dummyResponse);
    }

}

import java.io.Serializable;

class CalculationRequest implements Serializable {
    // Define fields and methods for CalculationRequest
}