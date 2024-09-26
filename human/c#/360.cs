csharp
using System;
using System.Net;
using System.Text.RegularExpressions;

public class CookieAwareWebClient : WebClient
{
    private readonly CookieContainer _cookieContainer;

    public CookieAwareWebClient(CookieContainer cookieContainer)
    {
        _cookieContainer = cookieContainer;
    }

    protected override WebRequest GetWebRequest(Uri address)
    {
        var request = (HttpWebRequest)base.GetWebRequest(address);
        request.CookieContainer = _cookieContainer;
        return request;
    }
}

class Program
{
    static void Main()
    {
        var cookieJar = new CookieContainer();
        CookieAwareWebClient client = new CookieAwareWebClient(cookieJar);

        // the website sets some cookie that is needed for login, and as well the 'authenticity_token' is always different
        string response = client.DownloadString("http://portal.movable.com/signin");

        // parse the 'authenticity_token' and cookie is auto handled by the cookieContainer
        string token = Regex.Match(response, "authenticity_token.+?value=\"(.+?)\"").Groups[1].Value;
        string postData =
            string.Format("utf8=%E2%9C%93&authenticity_token={0}&user[login]=USERNAME&user[password]=PASSWORD&user[offset]=5.5&user[remember_me]=0&button=", token);

        //WebClient.UploadValues is equivalent of Http url-encode type post
        client.Headers[HttpRequestHeader.ContentType] = "application/x-www-form-urlencoded";
        response = client.UploadString("http://portal.movable.com/signin", postData);

        Console.WriteLine(response);
    }
}