import org.springframework.http.HttpHeaders;

public class Temp3333 {
    public static void main(String[] args) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        
        System.out.println("Headers: " + headers);
    }
}