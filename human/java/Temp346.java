public class Temp346 {
    public static void main(String[] args) {
        Temp346 temp = new Temp346();
        ThreadGroup g = new ThreadGroup("ExampleGroup");
        Thread t = new Thread(g, "ExampleThread");
        temp.checkAccess(g);
        temp.checkAccess(t);
    }

    public void checkAccess(ThreadGroup g) {
        System.out.println("Access for " + g);
        g.checkAccess();
    }

    public void checkAccess(Thread t) {
        System.out.println("Access for " + t);
        t.checkAccess();
    }
}