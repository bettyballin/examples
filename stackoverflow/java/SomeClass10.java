import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.model.Organization;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SomeClass10 {
    public void someMethod(HttpServletRequest req, List<Organization> mylist, String userId) {
        try {
            User user = (User) req.getAttribute(WebKeys.USER);
            PrincipalThreadLocal.setName(userId);
            PermissionChecker permissionChecker;

            permissionChecker = PermissionCheckerFactoryUtil.create(user);
            PermissionThreadLocal.setPermissionChecker(permissionChecker);

            Organization organization = mylist.get(0);

            ExpandoBridge expandoBridge = organization.getExpandoBridge();
            System.out.println(expandoBridge.getAttribute("custom_field"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}