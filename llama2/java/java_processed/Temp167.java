public class Temp167 {
    private static final String INVALID_ARGUMENT_MESSAGE = "Invalid Argument";

    public static void main(String[] args) {
        Temp167 temp = new Temp167();
        temp.doSomething("test");
    }

    public void doSomething(String argument) {
        if (!checkArgument(argument)) {
            throw new IllegalArgumentException(INVALID_ARGUMENT_MESSAGE);
        }

        // Add the rest of your code here
        System.out.println("Argument is valid: " + argument);
    }

    private boolean checkArgument(String argument) {
        // Replace this with actual validation logic
        return argument != null && !argument.isEmpty();
    }
}