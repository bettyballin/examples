import org.springframework.security.core.GrantedAuthority;

public class Temp285 {
    public static void main(String[] args) {
        // Your main method implementation here
    }

    public interface WidgetAccessAuthority extends GrantedAuthority {
        String getWidgetId();
    }
}
``` won't work because you can't define an interface inside a class. Here is the corrected version:

```java
import org.springframework.security.core.GrantedAuthority;

public class Temp285 {
    public static void main(String[] args) {
        // Your main method implementation here
    }
}

interface WidgetAccessAuthority extends GrantedAuthority {
    String getWidgetId();
}
```
However, if you want the interface to be a nested interface for some reason, you should make it static:

```java
import org.springframework.security.core.GrantedAuthority;

public class Temp285 {
    public static void main(String[] args) {
        // Your main method implementation here
    }

    public static interface WidgetAccessAuthority extends GrantedAuthority {
        String getWidgetId();
    }
}