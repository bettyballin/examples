import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.expando.kernel.model.ExpandoBridge;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Temp2368 {
    public static void main(String[] args) {
        try {
            // Mocking data for demonstration purposes
            HttpServletRequest req = null; // You need to obtain the actual HttpServletRequest
            long userId = 0; // You need to obtain the actual userId

            // Assuming the user is retrieved from the request
            User user = UserLocalServiceUtil.getUser(userId); // Alternatively, use req.getAttribute(WebKeys.USER);
            PrincipalThreadLocal.setName(userId);
            PermissionChecker permissionChecker;

            permissionChecker = PermissionCheckerFactoryUtil.create(user);
            PermissionThreadLocal.setPermissionChecker(permissionChecker);

            // Mocking organization list for demonstration purposes
            List<Organization> mylist = getOrganizations(); // Replace with actual organization list retrieval

            Organization organization = mylist.get(0);

            ExpandoBridge expandoBridge = organization.getExpandoBridge();
            System.out.println(expandoBridge.getAttribute("custom_field"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Mock method to simulate organization retrieval
    private static List<Organization> getOrganizations() {
        // Replace with actual organization retrieval logic
        return null;
    }
}