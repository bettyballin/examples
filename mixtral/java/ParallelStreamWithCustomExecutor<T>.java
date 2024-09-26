import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class ParallelStreamWithCustomExecutor<T> extends AbstractCollection<T> {

    private final Collection<T> collection;
    private final ExecutorService executor;

    public ParallelStreamWithCustomExecutor(Collection<T> collection, int threadPoolSize) {
        this.collection = collection;
        this.executor = Executors.newFixedThreadPool(threadPoolSize);
    }

    public Stream<T> getStream() {
        return collection.parallelStream();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        executor.execute(() -> getStream().forEachOrdered(action));
    }

    @Override
    public Iterator<T> iterator() {
        return collection.iterator();
    }

    @Override
    public int size() {
        return collection.size();
    }
    
    @Override
    public Spliterator<T> spliterator() {
        return collection.spliterator();
    }

    public void shutdown() {
        executor.shutdown();
    }

    public static void main(String[] args) {
        Collection<Integer> list = List.of(1, 2, 3, 4, 5);
        ParallelStreamWithCustomExecutor<Integer> customExecutor = new ParallelStreamWithCustomExecutor<>(list, 2);
        
        customExecutor.forEach(System.out::println);
        customExecutor.shutdown();
    }
}