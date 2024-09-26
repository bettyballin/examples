public class Temp388 {
    public static void main(String[] args) {
        SandboxContext context = new SandboxContext();
        context.setClassFilter(new CustomClassFilter());
        // ... configure and run sandbox as before ...
    }
}

// You need to define the SandboxContext and CustomClassFilter classes
class SandboxContext {
    private CustomClassFilter classFilter;

    public void setClassFilter(CustomClassFilter classFilter) {
        this.classFilter = classFilter;
    }

    // Other methods to configure and run the sandbox
}

class CustomClassFilter {
    // Define the filtering logic here
}