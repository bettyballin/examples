csharp
using System;
using System.IO;
using System.Net;
using System.Web;
using System.Web.Mvc;

public class DownloadController : Controller
{
    private static readonly char[] InvalidFilenameChars = Path.GetInvalidFileNameChars();

    public ActionResult Download(string fileName)
    {
        if (fileName.IndexOfAny(InvalidFilenameChars) >= 0)
            return new HttpStatusCodeResult(HttpStatusCode.BadRequest);

        var rootPath = Server.MapPath("~/ClientDocument/");
        byte[] fileBytes = System.IO.File.ReadAllBytes(Path.Combine(rootPath, fileName));
        return File(fileBytes, System.Net.Mime.MediaTypeNames.Application.Octet, fileName);
    }
}