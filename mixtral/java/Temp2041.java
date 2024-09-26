import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@EnableAsync
public class Temp2041 {

    @Autowired
    private SimpMessagingTemplate template;

    public void sendMessage(String destination, String message) {
        this.template.convertAndSend(destination, message);
    }

    // Dummy calculation method to replace your actual calculation logic
    private String calculate(Calculation calculation) {
        // Perform some calculation and return result as string
        return "Calculated result";
    }

    // In your controller
    @PostMapping("/calculate")
    public ResponseEntity<String> calculate(@RequestBody Calculation calculation) throws Exception {

        // Send dummy response immediately
        ResponseEntity<String> response = new ResponseEntity<>("Calculations started", HttpStatus.OK);

        // Start a separate thread for calculations
        CompletableFuture.runAsync(() -> {
            try {
                String result = calculate(calculation);

                // After calculation is done send actual data to client
                this.sendMessage("/topic/results", result);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return response;
    }

    static class Calculation {
        // Define fields and methods as per your requirement
    }
}