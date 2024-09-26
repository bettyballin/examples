csharp
using System;
using System.ServiceModel;
using System.ServiceModel.Channels;
using System.Windows.Forms;

class Program
{
    static void Main()
    {
        using (var test = new YourServiceClient()) // Replace with your service client
        {
            using (new OperationContextScope(test.InnerChannel))
            {
                MessageHeader aMessageHeader = MessageHeader.CreateHeader("UsernameToken", "http://tempuri.org", "TOTOTO");
                OperationContext.Current.OutgoingMessageHeaders.Add(aMessageHeader);

                getGreeting test2 = new getGreeting();
                MessageBox.Show(test.getGreeting(test2).greeting);
            }
        }
    }
}