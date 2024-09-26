csharp
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.ViewFeatures;

public class SmidgeController : Controller
{
    [ViewComponent(Name = "Smidge")]
    public class SmidgeViewComponent : ViewComponent
    {
        public async Task<IViewComponentResult> InvokeAsync()
        {
            return View();
        }
    }

    public IActionResult Index()
    {
        return View();
    }
}

[HtmlTargetElement("addTagHelper", Attributes = "*, Smidge")]
public class SmidgeTagHelper : TagHelper
{
    public override void Process(TagHelperContext context, TagHelperOutput output)
    {
        output.Content.SetContent("Smidge Tag Helper");
    }
}

public static class SmidgeHelper
{
    public static string GetSmidgeHelper(this IHtmlHelper htmlHelper)
    {
        return "Smidge Helper";
    }
}