import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.WebKeys;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

public class Temp1499 {
    private static final Log _log = LogFactoryUtil.getLog(Temp1499.class);

    public static void main(String[] args) {
        HttpServletRequest req = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(args[0])); // Adjust based on how you get HttpServletRequest

        long userId = (Long) req.getSession().getAttribute(WebKeys.USER_ID);
        List<Organization> mylist = OrganizationLocalServiceUtil.getUserOrganizations(userId);

        if (!mylist.isEmpty()) {
            ServiceContext serviceContext = new ServiceContext();

            // Set the required attributes for permission checks
            User user = UserLocalServiceUtil.fetchUser(userId);

            if (user != null) {
                ThemeDisplay themeDisplay = new ThemeDisplay();

                try {
                    Locale locale = LocaleThreadLocal.getThemeLocale();

                    // Set the required attributes for permission checks
                    serviceContext.setCompanyId(PortalUtil.getDefaultCompanyId());
                    serviceContext.setScopeGroupId(user.getGroup().getParentGroupId());

                    themeDisplay.setUser(user);

                    if (Validator.isNotNull(locale)) {
                        themeDisplay.setLocale(locale);

                        // Set the required attributes for permission checks
                        serviceContext.setLanguageId(themeDisplay.getLanguage().toString());

                        Organization organization = mylist.get(0);

                        ExpandoBridge expandoBridge = organization.getExpandoBridge();

                        // Retrieve the custom field value
                        Object attributeValue = expandoBridge.getAttribute("custom_field");

                        System.out.println(attributeValue);
                    }
                } catch (Exception e) {
                    _log.error(e, e);

                    try {
                        throw new PortalException();
                    } catch (PortalException portalException) {
                        _log.error(portalException.getMessage(), portalException);
                    }
                }
            }
        }
    }
}