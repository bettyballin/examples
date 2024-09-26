class SystemReader {
    private static SystemReader instance = new SystemReader();

    public static SystemReader getInstance() {
        return instance;
    }

    public static void setInstance(SystemReader instance) {
        SystemReader.instance = instance;
    }

    public String read() {
        return "Default SystemReader";
    }
}

class CustomSystemReader extends SystemReader {
    private SystemReader original;

    public CustomSystemReader(SystemReader original) {
        this.original = original;
    }

    @Override
    public String read() {
        return "Custom SystemReader";
    }
}

public class Temp2821 {
    public static void main(String[] args) {
        SystemReader.setInstance(
                new CustomSystemReader(SystemReader.getInstance()));

        // Example usage
        System.out.println(SystemReader.getInstance().read());
    }
}