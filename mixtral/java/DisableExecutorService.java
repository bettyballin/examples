public class DisableExecutorService implements GroupProperty {
    @Override
    public String getName() {
        return "hazelcast.executor.enabled";
    }

    @Override
    public boolean isRequired() {
        return false;
    }

    @Override
    public Class<?> getType() {
        return Boolean.class;
    }

    @Override
    public String getDefaultValue() {
        return "true";
    }

    public static void main(String[] args) {
        DisableExecutorService disableExecutorService = new DisableExecutorService();
        System.out.println("Name: " + disableExecutorService.getName());
        System.out.println("Is Required: " + disableExecutorService.isRequired());
        System.out.println("Type: " + disableExecutorService.getType());
        System.out.println("Default Value: " + disableExecutorService.getDefaultValue());
    }
}

// Assuming GroupProperty is an interface like below
interface GroupProperty {
    String getName();
    boolean isRequired();
    Class<?> getType();
    String getDefaultValue();
}