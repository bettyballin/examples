csharp
using System;
using System.IO.Pipes;
using System.Security.AccessControl;
using System.Security.Principal;

class Program
{
    static void Main()
    {
        string pipeName = "MyPipe";
        PipeSecurity pipeSecurity = CreateSystemIOPipeSecurity();
        NamedPipeServerStream pipeServer = new NamedPipeServerStream(pipeName,
                                       PipeDirection.InOut,
                                       1,
                                       PipeTransmissionMode.Message,
                                       PipeOptions.Asynchronous,
                                       0x4000,
                                       0x400,
                                       pipeSecurity,
                                       HandleInheritability.Inheritable);
        Console.WriteLine("Named pipe server created.");
    }

    static PipeSecurity CreateSystemIOPipeSecurity()
    {
        PipeSecurity pipeSecurity = new PipeSecurity();

        // Allow Everyone read and write access to the pipe.
        pipeSecurity.AddAccessRule(new PipeAccessRule("Everyone",
            PipeAccessRights.ReadWrite, AccessControlType.Allow));

        // Allow the Administrators group to access the pipe.
        pipeSecurity.AddAccessRule(new PipeAccessRule(new SecurityIdentifier(WellKnownSidType.BuiltinAdministratorsSid, null),
            PipeAccessRights.ReadWrite, AccessControlType.Allow));

        return pipeSecurity;
    }
}