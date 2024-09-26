public class Temp629 {
    public static void main(String[] args) {
        // Main method implementation
    }

    public interface ManagedEntity {
        Manager getManager();
    }

    public interface Manager {
        // Manager interface methods
    }
    
    public static class ManagerImpl implements Manager {
        // Manager implementation methods
    }

    public static class ManagedEntityImpl implements ManagedEntity {
        @Override
        public Manager getManager() {
            return new ManagerImpl();
        }
    }
}