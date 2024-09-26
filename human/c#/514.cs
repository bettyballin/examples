csharp
using NLog;
using NLog.Targets;

namespace NLog.CustomExtendedService
{
    [Target("LogReceiverSecureService")]
    public class LogReceiverSecureService : LogReceiverWebServiceTarget
    {
        /// <summary>
        /// Gets or sets the UserName of the service when it's authentication is set to UserName
        /// </summary>
        /// <value>The name of the endpoint configuration.</value>
        public string ServiceUsername { get; set; }

        /// <summary>
        /// Gets or sets de Password of the service when it's authentication is set to UserName
        /// </summary>
        public string ServicePassword { get; set; }

        /// <summary>
        /// Creates a new instance of WcfLogReceiverClient.
        /// 
        /// We make override over this method to allow the authentication
        /// </summary>
        /// <returns></returns>
        protected override WcfLogReceiverClient CreateWcfLogReceiverClient()
        {
            var client = base.CreateWcfLogReceiverClient();
            if (client.ClientCredentials != null)
            {
                //
                // You could use the config file configuration (this example) or you could hard-code it (if you do not want to expose the credentials)
                //
                client.ClientCredentials.UserName.UserName = this.ServiceUsername;
                client.ClientCredentials.UserName.Password = this.ServicePassword;
            }
            return client;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            var config = new LoggingConfiguration();
            var target = new LogReceiverSecureService
            {
                ServiceUsername = "your_username",
                ServicePassword = "your_password",
                EndpointConfigurationName = "your_endpoint_config_name",
                EndpointAddress = "http://your_service_url"
            };
            config.AddTarget("LogReceiverSecureService", target);
            config.LoggingRules.Add(new LoggingRule("*", LogLevel.Debug, target));
            LogManager.Configuration = config;

            var logger = LogManager.GetLogger("Example");
            logger.Debug("This is a debug message.");

            LogManager.Shutdown();
        }
    }
}