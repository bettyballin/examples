import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Temp1113 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // Example data for demonstration purposes
        List<String> dataChunks = List.of("chunk1", "chunk2", "chunk3");

        CompletableFuture<?>[] futures = new CompletableFuture[dataChunks.size()];

        for (int i = 0; i < dataChunks.size(); ++i) {
            final int index = i;

            // Submit each chunk to be encrypted in a separate thread
            futures[index] = CompletableFuture.runAsync(() -> {
                try {
                    String result = encrypt(dataChunks.get(index));
                    // Store the results
                    System.out.println("Encrypted: " + result);
                } catch (Exception e) {
                    throw new RuntimeException("Error during encryption", e);
                }
            }, executor).exceptionally((throwable) -> {
                System.out.println("An error occurred: " + throwable.getMessage());
                return null;
            });
        }

        // Wait for all tasks to complete
        CompletableFuture.allOf(futures).join();

        executor.shutdown();
    }

    // Dummy encryption method for demonstration purposes
    private static String encrypt(String data) {
        return "encrypted_" + data;
    }
}