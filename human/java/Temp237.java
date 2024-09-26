public class Temp237 {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("MyGroup");
        Runnable target = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread is running");
            }
        };
        Thread thread = new Thread(group, target, "MyThread");
        thread.start();
    }
}