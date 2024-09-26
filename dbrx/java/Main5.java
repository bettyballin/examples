import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        SecureRandom secureRandom = SecureRandom.getInstance("DRBG");
        
        // Get provider name and algorithm details.
        String providerName = secureRandom.getProvider().getName();
        System.out.println("Provider Name: " + providerName);

        if (providerName.equalsIgnoreCase("SUN")) {
            // Using reflection to access the internal class and method
            try {
                Object secureRandomParams = secureRandom.getParameters();
                java.lang.reflect.Method getSecurityStrengthMethod = secureRandomParams.getClass().getDeclaredMethod("getSecurityStrength");
                getSecurityStrengthMethod.setAccessible(true);
                int securityStrength = (int) getSecurityStrengthMethod.invoke(secureRandomParams);
                
                switch(securityStrength){
                    case 128:
                        System.out.println("Algorithm used is Hash_DRBG");
                        break;
                    case 256:
                        System.out.println("Algorithm used is HMAC_DRBG or CTR_DRBG");
                        // To differentiate between HMAC_DRBG and CTR_DRBG
                        java.lang.reflect.Method getMechanismMethod = secureRandomParams.getClass().getDeclaredMethod("getMechanism");
                        getMechanismMethod.setAccessible(true);
                        String algorithm = (String) getMechanismMethod.invoke(secureRandomParams);
                        if(algorithm.equalsIgnoreCase("HMAC")){
                            System.out.println("Algorithm used is HMAC_DRBG");
                        }else{
                            System.out.println("Algorithm used is CTR_DRBG");
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + securityStrength);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Handle other providers here.
        }
    }
}