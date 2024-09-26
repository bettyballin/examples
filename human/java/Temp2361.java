public class Temp2361 {
    public static void main(String[] args) {
        try {
            throw new org.springframework.beans.factory.BeanCreationException("Bean creation failed");
        } catch (org.springframework.beans.factory.BeanCreationException e) {
            System.out.println("Caught exception: " + e);
        }
    }
}