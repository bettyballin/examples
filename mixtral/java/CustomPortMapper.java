public interface PortMapper {
    int getTargetPort(int source);
}

public class CustomPortMapper implements PortMapper {
    @Override
    public int getTargetPort(int source) {
        if (source == 8080) {
            return 443;
        }

        throw new IllegalArgumentException("Invalid port: " + source);
    }

    public static void main(String[] args) {
        CustomPortMapper portMapper = new CustomPortMapper();
        try {
            int targetPort = portMapper.getTargetPort(8080);
            System.out.println("Target port for 8080 is: " + targetPort);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            int targetPort = portMapper.getTargetPort(80);
            System.out.println("Target port for 80 is: " + targetPort);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}