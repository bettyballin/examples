import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@SpringBootApplication
public class FavIconApplication {

    public static void main(String[] args) {
        SpringApplication.run(FavIconApplication.class, args);
    }
}

@RestController
class FavIconController {

    @GetMapping("/favicon.ico")
    public void getFavIcon(HttpServletResponse response) throws IOException {
        // Return your default favicon here
        InputStream in = this.getClass().getResourceAsStream("/path/to/your/default-favicon.png");

        if (in == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        response.setContentType("image/x-icon");
        OutputStream out = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int length;

        while ((length = in.read(buffer)) != -1) {
            out.write(buffer, 0, length);
        }

        in.close();
        out.close();
    }
}