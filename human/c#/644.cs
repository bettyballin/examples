This is not C# code, but rather an XML configuration snippet. However, I can provide you with a C# code that would allow you to create a custom event handler:

csharp
using System;
using Sitecore.Events;

namespace Sirano.Dev.ItemEventHandlers
{
    public class CustomItemEventHandler
    {
        public void OnItemCreated(object sender, EventArgs args)
        {
            // Your custom code here
        }
    }
}