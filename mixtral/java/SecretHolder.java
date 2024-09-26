import java.lang.reflect.Field;

public class SecretHolder {
    private String secretKey;

    public void setSecret(String key) {
        this.secretKey = key;
    }

    public static void main(String[] args) {
        try {
            SecretHolder holder = new SecretHolder();
            holder.setSecret("mySecret");

            maliciousMethod(holder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void maliciousMethod(SecretHolder holder) throws NoSuchFieldException, IllegalAccessException {
        Field secretKeyField = SecretHolder.class.getDeclaredField("secretKey");

        if (!secretKeyField.isAccessible())
            secretKeyField.setAccessible(true);

        String keyValue = (String) secretKeyField.get(holder);

        // Now the attacker has access to the private member variable and can manipulate it
        System.out.println("Accessed secret key: " + keyValue);
    }
}