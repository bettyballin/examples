csharp
using System;
using System.Runtime.InteropServices;

class Program
{
    [DllImport("kernel32")]
    private static extern bool CloseHandle(IntPtr hObject);

    private IntPtr _userToken = IntPtr.Zero;

    static void Main()
    {
        Program program = new Program();
        program._userToken = new IntPtr(1); // Assign a non-zero value for demonstration purposes
        program.CloseUserToken();
    }

    private void CloseUserToken()
    {
        if (_userToken != IntPtr.Zero)
            CloseHandle(_userToken);
    }
}