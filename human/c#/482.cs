This is not C# code, it's a snippet of a Web.config file. However, I can provide you with a basic C# web application that includes a Web.config file with the given custom error settings:

**Web.config:**

<?xml version="1.0"?>
<configuration>
  <system.web>
    <customErrors mode="On" defaultRedirect="ErrorPage.aspx">
      <error statusCode="403" redirect="ErrorNoAccess.aspx" />
      <error statusCode="404" redirect="ErrorNotFound.aspx" />
      <error statusCode="500" redirect="ErrorPage.aspx" />
    </customErrors>
  </system.web>
</configuration>


**ErrorPage.aspx:**

<%@ Page Language="C#" %>
<!DOCTYPE html>
<html>
<head>
  <title>Error Page</title>
</head>
<body>
  <h1>Error Page</h1>
  <p>An error occurred.</p>
</body>
</html>


**ErrorNoAccess.aspx:**

<%@ Page Language="C#" %>
<!DOCTYPE html>
<html>
<head>
  <title>No Access Error Page</title>
</head>
<body>
  <h1>No Access Error Page</h1>
  <p>You do not have access to this page.</p>
</body>
</html>


**ErrorNotFound.aspx:**

<%@ Page Language="C#" %>
<!DOCTYPE html>
<html>
<head>
  <title>Not Found Error Page</title>
</head>
<body>
  <h1>Not Found Error Page</h1>
  <p>The requested page was not found.</p>
</body>
</html>


**Default.aspx:**

<%@ Page Language="C#" %>
<!DOCTYPE html>
<html>
<head>
  <title>Default Page</title>
</head>
<body>
  <h1>Default Page</h1>
  <p>This is the default page.</p>
</body>
</html>


**Program.cs (for .NET 6 and later):**
csharp
var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllersWithViews();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/ErrorPage.aspx");
}

app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller}/{action}/{id}",
    defaults: new { controller = "Home", action = "Index", id = UrlParameter.Optional }
);

app.Run();

Note: For .NET versions prior to .NET 6, you would use a different Program.cs file.