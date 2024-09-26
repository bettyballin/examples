csharp
using System;
using System.ServiceProcess;

class MyService : ServiceBase
{
    public static void Main()
    {
        ServiceBase[] ServicesToRun;
        ServicesToRun = new ServiceBase[]
        {
            new MyService()
        };
        ServiceBase.Run(ServicesToRun);
    }

    public MyService()
    {
        ServiceName = "MyService";
    }

    protected override void Start(string[] args)
    {
        // Start code here
    }

    protected override void Stop()
    {
        // Stop code here
    }
}