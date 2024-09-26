csharp
using System;
using System.Security.Claims;
using System.Web;
using System.Web.Mvc;
using System.Web.Caching;

public class ValidateThumbprint : FilterAttribute, IAuthorizationFilter
{
    public void OnAuthorization(AuthorizationContext filterContext)
    {
        var identity = (ClaimsIdentity)filterContext.HttpContext.User.Identity;
        var thumbPrint = identity.Claims?.Where(s => s.Type == ClaimTypes.Thumbprint).FirstOrDefault()?.Value;

        if (thumbPrint != null)
        {
            if (MemoryCache.Default.Contains(thumbPrint))
            {
                return;
            }
        }
        // handle invalid thumbprint
        filterContext.Result = new HttpUnauthorizedResult();
    }
}