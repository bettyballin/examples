csharp
using System;
using log4net;
using log4net.Config;

namespace MaxRateExample
{
    public class MaxRateForwardingAppender : log4net.Appender.ForwardingAppender
    {
        public MaxRateForwardingAppender()
        {
            AddAppender((IAppender)LogManager.GetLogger("RollingFileAppender"));
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            log4net.Config.XmlConfigurator.Configure();
            ILog logger = LogManager.GetLogger(typeof(Program));
            logger.Info("Hello World!");
        }
    }
}