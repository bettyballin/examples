csharp
using System;
using System.Collections.Generic;
using System.Web;

public class Global : HttpApplication
{
    protected void Application_BeginRequest(object sender, EventArgs e)
    {
        List<string> Domains = new List<string> { "www.domain1.com", "www.domain2.com", "www.domain3.com" };
        string currentDomain = Request.Url.Host;
        //string currentDomain = Request.Url.Authority; //Returns localhost:1234 if you want to test in localhost
        if (!Domains.Contains(currentDomain.ToLower()))
            throw new Exception("Domain name is not considered");
    }
}