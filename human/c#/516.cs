csharp
using System;
using System.Configuration;
using NLog;
using NLog.Config;
using NLog.Targets;

public class NLogCustomExtendedService
{
    public static void Main(string[] args)
    {
        // Create a new LoggingConfiguration object
        var config = new LoggingConfiguration();

        // Create a new target
        var target = new LogReceiverSecureServiceTarget
        {
            Name = "RemoteWcfLogger",
            EndpointConfigurationName = "WSHttpBinding_ILogReceiverServer",
            EndpointAddress = "https://your_secure_domain.com/servicePath/Logger.svc",
            ServiceUsername = "your_username_here",
            ServicePassword = "your_password_here",
            UseBinaryEncoding = true,
            ClientId = "YourApplicationNameOrId",
            IncludeEventProperties = true
        };

        // Add the target to the configuration
        config.AddTarget(target);

        // Create a new rule
        var rule = new LoggingRule("*", LogLevel.Debug, target);

        // Add the rule to the configuration
        config.LoggingRules.Add(rule);

        // Set the configuration
        LogManager.Configuration = config;

        // Log a message
        var logger = LogManager.GetLogger("NLogCustomExtendedService");
        logger.Info("Hello, world!");
    }
}

[Target("LogReceiverSecureService")]
public class LogReceiverSecureServiceTarget : Target
{
    [RequiredParameter]
    public string EndpointConfigurationName { get; set; }

    [RequiredParameter]
    public string EndpointAddress { get; set; }

    [RequiredParameter]
    public string ServiceUsername { get; set; }

    [RequiredParameter]
    public string ServicePassword { get; set; }

    public bool UseBinaryEncoding { get; set; }

    [RequiredParameter]
    public string ClientId { get; set; }

    public bool IncludeEventProperties { get; set; }

    protected override void Write(LogEventInfo logEvent)
    {
        // Implement the logging logic here
        Console.WriteLine(logEvent.Message);
    }
}