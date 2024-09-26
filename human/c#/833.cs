csharp
using System;
using System.IO.Pipes;
using System.Security.AccessControl;
using System.Security.Principal;

class Program
{
    static void Main(string[] args)
    {
        PipeSecurity pipeSecurity = CreateSystemIOPipeSecurity();

        using (NamedPipeServerStream pipeServer = new NamedPipeServerStream("MyPipe", PipeDirection.InOut, 1, PipeTransmissionMode.Byte, PipeOptions.Asynchronous, 0, 0, pipeSecurity))
        {
            Console.WriteLine("Named pipe created with custom security settings.");
        }
    }

    // Creates a PipeSecurity that allows users read/write access
    static PipeSecurity CreateSystemIOPipeSecurity()
    {
        PipeSecurity pipeSecurity = new PipeSecurity();

        var id = new SecurityIdentifier(WellKnownSidType.AuthenticatedUserSid, null);

        // Allow Everyone read and write access to the pipe. 
        pipeSecurity.SetAccessRule(new PipeAccessRule(id, PipeAccessRights.ReadWrite, AccessControlType.Allow));

        return pipeSecurity;
    }
}