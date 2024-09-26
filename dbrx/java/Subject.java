import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer){
        observers.add(observer);                
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }    
}

class A extends Subject {
    // Additional methods and properties specific to A
}

class D extends Subject {
    // Additional methods and properties specific to D
}

class C implements Observer {
    @Override
    public void update() {
        // Do something here when notified by either class 'A' or Class 'D'
        System.out.println("Observer C updated");
    }
}

public class Main {
    public static void main(String[] args) {
        A a = new A();
        D d = new D();
        C c = new C();

        a.attach(c);
        d.attach(c);

        a.notifyObservers(); // This will call update() on observer c
        d.notifyObservers(); // This will also call update() on observer c
    }
}