csharp
using Microsoft.AspNetCore.Razor.TagHelpers;

public class MyTagHelper : TagHelper
{
    public string Source { get; set; }

    public override void Process(TagHelperContext context, TagHelperOutput output)
    {
        // Pass through attribute that is also a well-known HTML attribute.
        // this is required to make sure that other tag helpers executing against this element have
        // the value copied across
        if (Source != null)
        {
            output.CopyHtmlAttribute("src", context);
        }
    }
}