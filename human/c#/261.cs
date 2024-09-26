csharp
using System;
using System.Diagnostics;

class Program
{
    static void Main(string[] args)
    {
        var config = @"
        <system.diagnostics>
          <sources>
            <source name=""System.ServiceModel"" switchValue=""Warning, ActivityTracing"" propagateActivity=""true"">
              <listeners>
                <add type=""System.Diagnostics.DefaultTraceListener"" name=""Default"">
                  <filter type="""" />
                </add>
                <add name=""ServiceModelTraceListener"">
                  <filter type="""" />
                </add>
              </listeners>
            </source>
          </sources>
          <sharedListeners>
            <add initializeData=""path\to\trace.svclog""
              type=""System.Diagnostics.XmlWriterTraceListener, System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089""
            name=""ServiceModelTraceListener"" traceOutputOptions=""Timestamp"">
            <filter type="""" />
          </add>
        </sharedListeners>
      </system.diagnostics>
    ";

        var xmlDoc = new System.Xml.XmlDocument();
        xmlDoc.LoadXml(config);

        var source = new TraceSource("System.ServiceModel", SourceLevels.Warning | SourceLevels.ActivityTracing);
        source.Listeners.Add(new DefaultTraceListener());
        source.Listeners.Add(new XmlWriterTraceListener("path\\to\\trace.svclog"));

        Console.WriteLine("Press any key to exit...");
        Console.ReadKey();
    }
}