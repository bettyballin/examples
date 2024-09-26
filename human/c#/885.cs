csharp
using System;
using System.Collections.Generic;
using System.IdentityModel.Claims;
using System.Runtime.Caching;
using Microsoft.Owin.Security;

private void OwinSignIn(tblUser user)
{
    var thumbPrint = Guid.NewGuid();
    var claims = new List<Claim>
    {
        new Claim(ClaimTypes.NameIdentifier, user.Id.ToString()),
        new Claim(ClaimTypes.Name, user.UserName),
        new Claim(ClaimTypes.Thumbprint, thumbPrint.ToString())
    };

    var identity = new ClaimsIdentity(claims, "ApplicationCookie");
    var context = new AuthenticationProperties { IsPersistent = true };
    var authenticationManager = Request.GetOwinContext().Authentication;
    authenticationManager.SignIn(new AuthenticationProperties { IsPersistent = true }, identity);

    MemoryCache.Default.Set(thumbPrint.ToString(), true, new CacheItemPolicy() { AbsoluteExpiration = DateTimeOffset.Now.AddMinutes(60) });
}