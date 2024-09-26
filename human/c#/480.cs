This is not C# code, it's a snippet of ASP.NET configuration XML. However, I'll provide a sample C# code that demonstrates how to configure custom errors programmatically:

csharp
using System.Configuration;

public class CustomErrorConfig
{
    public static void ConfigureCustomErrors()
    {
        Configuration config = WebConfigurationManager.OpenWebConfiguration("~");
        CustomErrorsSection customErrors = (CustomErrorsSection)config.GetSection("system.web/customErrors");

        customErrors.Mode = CustomErrorsMode.On;
        customErrors.DefaultRedirect = "ErrorPage.aspx";

        CustomError error401 = new CustomError();
        error401.StatusCode = 401;
        error401.Redirect = "ErrorNoAccess.aspx";
        customErrors.Errors.Add(error401);

        config.Save(ConfigurationSaveMode.Modified);
    }
}