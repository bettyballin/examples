import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Temp902 {
    private static final Logger LOG = Logger.getLogger(Temp902.class.getName());

    public static void main(String[] args) {
        Temp902 temp = new Temp902();
        Object[] objects = new Object[] {"SampleObject1", "SampleObject2"};
        temp.setSecuredObjectsList(objects);
    }

    public void setSecuredObjectsList(Object[] objects) {
        Map<String, String> rolesMap = new HashMap<String, String>();
        for (Object o : objects) {
            setSecuredObject(o, rolesMap);
        }

        setMethodRolesMap(rolesMap);
    }

    public void setSecuredObject(Object object, Map<String, String> rolesMap) {
        Class<?> cls = ClassHelper.getRealClass(object);
        findRoles(cls, rolesMap);
        if (rolesMap.isEmpty()) {
            LOG.warning("The roles map is empty, the service object is not protected");
        } else if (LOG.isLoggable(Level.FINE)) {
            for (Map.Entry<String, String> entry : rolesMap.entrySet()) {
                LOG.fine("Method: " + entry.getKey() + ", roles: " + entry.getValue());
            }
        }
    }

    public void setMethodRolesMap(Map<String, String> rolesMap) {
        // Dummy implementation for example purposes
        System.out.println("Setting method roles map: " + rolesMap);
    }

    public void findRoles(Class<?> cls, Map<String, String> rolesMap) {
        // Dummy implementation for example purposes
        rolesMap.put(cls.getName(), "ROLE_USER");
    }
}

class ClassHelper {
    public static Class<?> getRealClass(Object obj) {
        return obj.getClass();
    }
}