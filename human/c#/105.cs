csharp
using System;
using System.Web.Mvc;

public class EntityAuthRequired : FilterAttribute, IAuthorizationFilter 
{
    public void OnAuthorization(AuthorizationContext filterContext)
    {
        //Make sure that this is not NULL before assigning value as string...
        var entityCode = filterContext.RouteData.Values["entityCode"] as string;
        
        bool allowed = false; // your logic should be here...

        if (!allowed)
            filterContext.Result = new HttpUnauthorizedResult();            
    }
}