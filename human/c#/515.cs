csharp
using System;
using System.ServiceModel;

namespace NLog.LogReceiverService
{
    public class LogReceiverClient : ClientBase<ILogReceiverClient>, ILogReceiverClient
    {
        public LogReceiverClient(string endpointConfigurationName) : 
            base(endpointConfigurationName)
        {
        }

        public void Log(LogEventInfo logEvent)
        {
            Channel.Log(logEvent);
        }
    }

    public interface ILogReceiverClient
    {
        void Log(LogEventInfo logEvent);
    }

    public class LogEventInfo
    {
        public string LoggerName { get; set; }
        public LogLevel Level { get; set; }
        public string Message { get; set; }
        // Add other properties as needed
    }

    public enum LogLevel
    {
        Debug,
        Info,
        Warn,
        Error,
        Fatal
    }

    class Program
    {
        static void Main(string[] args)
        {
            LogReceiverClient client = new LogReceiverClient("WSHttpBinding_ILogReceiverServer");
            LogEventInfo logEvent = new LogEventInfo
            {
                LoggerName = "MyLogger",
                Level = LogLevel.Info,
                Message = "Hello, world!"
            };
            client.Log(logEvent);
            client.Close();
        }
    }
}