import java.util.List;
import java.util.Locale;

public class Temp200 {
    public static void main(String[] args) {
        // Example usage of the LocalService interface
        LocalService service = new LocalServiceImpl();
        List<Local> locals = service.findByLocale(Locale.US);
        locals.forEach(local -> System.out.println(local.getName()));
    }

    public interface LocalService {
        List<Local> findByLocale(Locale locale);
    }

    public static class LocalServiceImpl implements LocalService {
        @Override
        public List<Local> findByLocale(Locale locale) {
            // Dummy implementation for demonstration purposes
            return List.of(new Local("Example Place"));
        }
    }

    public static class Local {
        private String name;

        public Local(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}