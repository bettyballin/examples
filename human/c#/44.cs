This is not C# code, but rather a snippet of a Web.config file in XML format. Here is the corrected version:

xml
<configuration>
  <system.web>
    <httpHandlers>
      <add verb="*" path="*.html" type="System.Web.UI.PageHandlerFactory"/>
    </httpHandlers>
  </system.web>
</configuration>