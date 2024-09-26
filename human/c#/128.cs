csharp
using System;
using System.Security.Principal;
using System.ServiceModel;
using System.Threading;

public class MyPrincipal : IPrincipal
{
    public IIdentity Identity { get; set; }
    public bool IsInRole(string role) { return true; }
}

public class ObjectFactory
{
    public static object GetInstance(Type serviceType)
    {
        // implement your object factory logic here
        return Activator.CreateInstance(serviceType);
    }
}

public class ServiceFactory : IInstanceContextInitializer, IServiceBehavior
{
    private Type _serviceType;

    public ServiceFactory(Type serviceType)
    {
        _serviceType = serviceType;
    }

    public object GetInstance(InstanceContext instanceContext, Message message)
    {
        var principal =
            OperationContext.Current.ServiceSecurityContext.AuthorizationContext.Properties["Principal"] 
                as MyPrincipal;
        if (principal != null)
            Thread.CurrentPrincipal = principal;
        return ObjectFactory.GetInstance(_serviceType);
    }

    public void InitializeInstanceContext(InstanceContext instanceContext)
    {
    }

    public void AddBindingParameters(ServiceDescription serviceDescription, ServiceHostBase serviceHostBase, Collection<ServiceEndpoint> endpoints, BindingParameterCollection bindingParameters)
    {
    }

    public void ApplyDispatchBehavior(ServiceDescription serviceDescription, ServiceHostBase serviceHostBase)
    {
        foreach (ChannelDispatcher cd in serviceHostBase.ChannelDispatchers)
        {
            foreach (EndpointDispatcher ed in cd.Endpoints)
            {
                ed.DispatchRuntime.InstanceContextInitializers.Add(this);
            }
        }
    }

    public void Validate(ServiceDescription serviceDescription, ServiceHostBase serviceHostBase)
    {
    }
}

class Program
{
    static void Main()
    {
        using (var host = new ServiceHost(typeof(MyService)))
        {
            host.Description.Behaviors.Add(new ServiceFactory(typeof(MyService)));
            host.Open();
            Console.WriteLine("Service started. Press any key to exit...");
            Console.ReadKey();
        }
    }
}

[ServiceContract]
public interface IMyService
{
    [OperationContract]
    void MyMethod();
}

public class MyService : IMyService
{
    public void MyMethod()
    {
        Console.WriteLine("MyMethod called");
    }
}