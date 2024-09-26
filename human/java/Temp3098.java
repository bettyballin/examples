import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class UserService {
    public static CompletableFuture<String> getPublicContent() {
        return CompletableFuture.supplyAsync(() -> "Sample public content");
    }
}

public class Temp3098 {
    private String content;

    public static void main(String[] args) {
        Temp3098 temp = new Temp3098();
        temp.componentDidMount();
        System.out.println(temp.content);
    }

    public void componentDidMount() {
        UserService.getPublicContent().thenAccept(response -> {
            this.content = response;
            System.out.println("Content set to: " + this.content);
        }).join();
    }
}