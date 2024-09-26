public class Main {
    public static void main(String[] args) {
        // Simulating method invocation arguments
        Object[] methodArgs = new Object[]{42};

        // Getting the class of the first argument
        Class<?> clazz = methodArgs[0].getClass();
        System.out.println("Class of first argument: " + clazz.getName());

        // Checking if the first argument is an instance of Integer
        if (methodArgs[0] instanceof Integer) {
            int intValue = ((Integer) methodArgs[0]).intValue();
            System.out.println("Integer value: " + intValue);
        } else {
            System.out.println("First argument is not an Integer.");
        }
    }
}