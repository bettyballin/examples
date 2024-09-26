csharp
using System;
using System.ServiceModel;

[ServiceContract]
public interface IUserService
{
    [OperationContract]
    string GetUserName();

    [OperationContract]
    void SetUserName(string value);

    [OperationContract]
    string GetPassword();

    [OperationContract]
    void SetPassword(string value);
}

public class UserService : IUserService
{
    private string _userName;
    private string _password;

    public string GetUserName()
    {
        return _userName;
    }

    public void SetUserName(string value)
    {
        _userName = value;
    }

    public string GetPassword()
    {
        return _password;
    }

    public void SetPassword(string value)
    {
        _password = value;
    }
}

class Program
{
    static void Main()
    {
        var serviceHost = new ServiceHost(typeof(UserService));
        serviceHost.Open();

        var channelFactory = new ChannelFactory<IUserService>("UserService");
        var proxy = channelFactory.CreateChannel();

        proxy.SetUserName("John");
        proxy.SetPassword("Password123");

        Console.WriteLine(proxy.GetUserName());
        Console.WriteLine(proxy.GetPassword());

        channelFactory.Close();
        serviceHost.Close();
    }
}


xml
<?xml version="1.0" encoding="utf-8"?>
<configuration>
  <system.serviceModel>
    <services>
      <service name="UserService">
        <endpoint address="UserService" binding="basicHttpBinding" contract="IUserService" />
        <host>
          <baseAddresses>
            <add baseAddress="http://localhost:8080/" />
          </baseAddresses>
        </host>
      </service>
    </services>
    <client>
      <endpoint address="http://localhost:8080/UserService" binding="basicHttpBinding" contract="IUserService" name="UserService" />
    </client>
  </system.serviceModel>
</configuration>