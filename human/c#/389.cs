csharp
using System;
using System.Web.UI.Adapters;

namespace My.Custom
{
    public class RolesAwareControlAdapter : ControlAdapter
    {
        protected override void Render(HtmlTextWriter writer)
        {
            var anchor = (HtmlAnchor)Control;
            // Your custom rendering logic here
            writer.Write($"<a href=\"{anchor.HRef}\">{anchor.InnerText}</a>");
        }
    }
}