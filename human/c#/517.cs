csharp
using System.Web;
using System.Web.Mvc;

public class PermissionAuthoriseAttribute : AuthorizeAttribute
{
    protected override bool AuthorizeCore(HttpContextBase httpContext)
    {
        // Assuming PermissionAttribute is a custom attribute with a method called IsValidPermission
        var actionDescriptor = (ActionDescriptor)httpContext.Items["ActionDescriptor"];
        var permissionAttribute = (PermissionAttribute)actionDescriptor.ControllerDescriptor.GetCustomAttributes(typeof(PermissionAttribute), true).FirstOrDefault();

        if (permissionAttribute != null && permissionAttribute.IsValidPermission(httpContext))
            return true;

        return base.AuthorizeCore(httpContext);
    }
}

public class PermissionAttribute : Attribute
{
    public virtual bool IsValidPermission(HttpContextBase httpContext)
    {
        // Implement your permission checking logic here
        // For demonstration purposes, this always returns true
        return true;
    }
}