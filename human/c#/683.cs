csharp
using System;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Security.Claims;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;
using Microsoft.Owin.Security;
using Newtonsoft.Json;

public class LoginController : Controller
{
    public async Task<ActionResult> Login(LoginModel model, string returnUrl)
    {
        var getTokenUrl = string.Format(ApiEndPoints.AuthorisationTokenEndpoint.Post.Token, ConfigurationManager.AppSettings["ApiBaseUri"]);

        using (var httpClient = new HttpClient())
        {
            var content = new FormUrlEncodedContent(new[]
            {
                new KeyValuePair<string, string>("grant_type", "password"),
                new KeyValuePair<string, string>("username", model.EmailAddress),
                new KeyValuePair<string, string>("password", model.Password)
            });

            var result = await httpClient.PostAsync(getTokenUrl, content);

            if (result.IsSuccessStatusCode)
            {
                var resultContent = await result.Content.ReadAsStringAsync();
                var token = JsonConvert.DeserializeObject<Token>(resultContent);

                var options = new AuthenticationProperties
                {
                    AllowRefresh = true,
                    IsPersistent = true,
                    ExpiresUtc = DateTime.UtcNow.AddSeconds(int.Parse(token.expires_in))
                };

                var claims = new[]
                {
                    new Claim(ClaimTypes.Name, model.EmailAddress),
                    new Claim("AcessToken", string.Format("Bearer {0}", token.access_token)),
                };

                var identity = new ClaimsIdentity(claims, "ApplicationCookie");

                var owinContext = Request.GetOwinContext();
                owinContext.Authentication.SignIn(options, identity);
            }
            else
            {
                ModelState.AddModelError("", "Invalid username or password");
                return View(model);
            }
        }

        return RedirectToAction("Index", "Home");
    }
}