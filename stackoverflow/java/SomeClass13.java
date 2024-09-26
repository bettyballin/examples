import org.springframework.cache.annotation.Cacheable;

public class SomeClass13 {

    @Cacheable(value = "resultCache", key = "#root.methodName")
    public Result getResult() {
        // implementation here
        return new Result();
    }
}

class Result {
    // Result class implementation
}