import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;

public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        // Add your startup logic here
    }

    public static void main(String[] args) {
        // This main method is just for testing purposes
        AppInitializer initializer = new AppInitializer();
        try {
            initializer.onStartup(null); // In real scenario, the container won't be null
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}