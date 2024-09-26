import java.rmi.Remote;
import java.rmi.RemoteException;

public class Temp1901 {
    public static void main(String[] args) {
        // Example usage of MyService can be implemented here
    }

    public interface MyService extends Remote {
        void doSomething() throws RemoteException;
    }
}