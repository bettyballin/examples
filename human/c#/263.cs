csharp
using System;
using System.Web.Mvc;
using Newtonsoft.Json;

public class JsonNetResult : JsonResult
{
    public JsonNetResult()
    {
        JsonRequestBehavior = JsonRequestBehavior.AllowGet;
    }

    public override void ExecuteResult(ControllerContext context)
    {
        if (context == null)
        {
            throw new ArgumentNullException("context");
        }

        HttpResponseBase response = context.HttpContext.Response;

        response.ContentType = !string.IsNullOrEmpty(ContentType) ? ContentType : "application/json";

        if (ContentEncoding != null)
        {
            response.ContentEncoding = ContentEncoding;
        }

        if (Data != null)
        {
            var jsonSerializerSettings = new JsonSerializerSettings
            {
                ReferenceLoopHandling = ReferenceLoopHandling.Ignore
            };
            JsonTextWriter jsonWriter = new JsonTextWriter(response.Output) { Formatting = Formatting.Indented };
            JsonSerializer jsonSerializer = JsonSerializer.Create(jsonSerializerSettings);
            jsonSerializer.Serialize(jsonWriter, Data);
            jsonWriter.Flush();
        }
    }
}

public class MyController : Controller
{
    protected ActionResult JsonNet(object data)
    {
        JsonNetResult result = new JsonNetResult();
        result.JsonRequestBehavior = JsonRequestBehavior.AllowGet;
        result.Data = data;
        return result;
    }

    public ActionResult MyAction()
    {
        var data = new { foo = "bar", baz = "qux" };
        return JsonNet(data);
    }
}