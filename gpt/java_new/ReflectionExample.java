public class ReflectionExample {
    private String privateField = "Private Value";
    
    private void privateMethod() {
        System.out.println("Private Method Invoked");
    }
    
    public static void main(String[] args) throws Exception {
        ReflectionExample instance = new ReflectionExample();
        
        Field field = ReflectionExample.class.getDeclaredField("privateField");
        field.setAccessible(true);
        String fieldValue = (String) field.get(instance);
        System.out.println("Private Field Value: " + fieldValue);
        
        Method method = ReflectionExample.class.getDeclaredMethod("privateMethod");
        method.setAccessible(true);
        method.invoke(instance);
    }
}