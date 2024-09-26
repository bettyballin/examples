import java.util.Arrays;

public class MyClass {
    private final int[] storedArray;

    public MyClass(int[] array) {
        // Make a copy of the original array to avoid cross-session contamination or unintended sharing
        this.storedArray = Arrays.copyOf(array, array.length);
    }

    // For demonstration purposes, let's add a method to get the stored array
    public int[] getStoredArray() {
        return Arrays.copyOf(storedArray, storedArray.length);
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5};
        MyClass myClass = new MyClass(originalArray);

        // Print the stored array
        int[] storedArray = myClass.getStoredArray();
        System.out.println(Arrays.toString(storedArray));
    }
}