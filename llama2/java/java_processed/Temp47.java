import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ForkJoinPool;

public class Temp47 {
    public static void main(String[] args) {
        ForkJoinPool.commonPool().setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Uncaught exception in thread " + t.getName() + ": " + e.getMessage());
            }
        });
        
        Thread.setDefaultUncaughtExceptionHandler(null);
    }
}