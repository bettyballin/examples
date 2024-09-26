import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Foo {
    final ReadWriteLock lock = new ReentrantReadWriteLock();

    Object read() throws Exception {
        lock.readLock().lock();
        try {
            // Your code here
            Object result = new Object(); // Example result object
            return result;
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        try {
            Foo foo = new Foo();
            Object result = foo.read();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}