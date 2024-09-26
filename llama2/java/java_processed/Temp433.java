import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Temp433 {
    public static void main(String[] args) {
        List<String> listOfSomething = Arrays.asList("item1", "item2", "item3", "item4");

        ForkJoinPool pool = new ForkJoinPool(16);
        pool.submit(() -> {
            listOfSomething.parallelStream()
                .forEach(el -> {
                    System.out.println(el);
                });
        }).join();
    }
}