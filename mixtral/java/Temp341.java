import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public interface AdminRemoteInterface extends Remote {
    void doSomething() throws RemoteException;
}

public interface UserRemoteInterface extends Remote {
   // other methods for user
}

class Server extends UnicastRemoteObject implements AdminRemoteInterface, UserRemoteInterface {

    protected Server() throws RemoteException {
        super();
    }

    @Override
    public void doSomething() throws RemoteException {
        System.out.println("Admin called this method");
        // additional implementation here
    }

    // other methods for user
}

public class Main {
    public static void main(String[] args) {
        try {
            Server server = new Server();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("AdminRemoteInterface", server);
            registry.rebind("UserRemoteInterface", server);
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}