csharp
using System;
using System.Web.Mvc;
using Newtonsoft.Json;

public class JsonNetResult : ActionResult
{
    public JsonNetResult()
    {
        SerializerSettings = new JsonSerializerSettings();
        JsonRequestBehavior = JsonRequestBehavior.DenyGet;
    }

    public JsonRequestBehavior JsonRequestBehavior { get; set; }
    public JsonSerializerSettings SerializerSettings { get; set; }
    public object Data { get; set; }

    public override void ExecuteResult(ControllerContext context)
    {
        if (context == null)
            throw new ArgumentNullException("context");

        var httpMethod = context.HttpContext.Request.HttpMethod;

        if (JsonRequestBehavior == JsonRequestBehavior.DenyGet && 
            string.Equals(httpMethod, "GET", StringComparison.OrdinalIgnoreCase))
        {
            throw new InvalidOperationException("You can't access this action with GET");
        }

        var response = context.HttpContext.Response;
        response.ContentType = "application/json";

        if (Data != null)
        {
            var writer = new JsonTextWriter(response.Output);
            var serializer = JsonSerializer.Create(SerializerSettings);
            serializer.Serialize(writer, Data);
            writer.Flush();
        }
    }
}