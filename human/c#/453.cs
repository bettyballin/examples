csharp
using System;
using System.Runtime.InteropServices;
using Microsoft.VisualStudio.TestTools.UnitTesting;

public class Credential
{
    public string UserName { get; set; }
    public string Password { get; set; }
}

public static class CredentialManager
{
    [DllImport("advapi32.dll", SetLastError = true)]
    private static extern bool CredWrite([In] CREDENTIALW cred, [In] uint flags);

    [DllImport("advapi32.dll", SetLastError = true, EntryPoint = "CredReadW")]
    private static extern bool CredRead([In] string target, [In] uint type, [In] uint flags, out IntPtr credPtr);

    [DllImport("advapi32.dll", SetLastError = true)]
    private static extern bool CredDelete([In] string target, [In] uint type, [In] uint flags);

    [DllImport("kernel32.dll")]
    private static extern void CoTaskMemFree(IntPtr ptr);

    [StructLayout(LayoutKind.Sequential, CharSet = CharSet.Unicode)]
    private struct CREDENTIALW
    {
        public uint Flags;
        public uint Type;
        public IntPtr TargetName;
        public IntPtr Comment;
        public System.Runtime.InteropServices.ComTypes.FILETIME LastWritten;
        public uint CredentialBlobSize;
        public IntPtr CredentialBlob;
        public uint Persist;
        public uint Attributes;
        public IntPtr TargetAlias;
        public IntPtr UserName;
    }

    public static void WriteCredential(string applicationName, string username, string password, CredentialPersistence persistence)
    {
        IntPtr cred = Marshal.AllocHGlobal(Marshal.SizeOf(typeof(CREDENTIALW)));
        CREDENTIALW credStruct = new CREDENTIALW();
        credStruct.Flags = 0;
        credStruct.Type = 1;
        credStruct.TargetName = Marshal.StringToCoTaskMemUni(applicationName);
        credStruct.UserName = Marshal.StringToCoTaskMemUni(username);
        credStruct.Persist = (uint)persistence;
        credStruct.CredentialBlobSize = (uint)password.Length * 2;
        credStruct.CredentialBlob = Marshal.StringToCoTaskMemUni(password);
        Marshal.StructureToPtr(credStruct, cred, true);
        CredWrite(cred, 0);
        Marshal.FreeHGlobal(cred);
        Marshal.FreeHGlobal(credStruct.TargetName);
        Marshal.FreeHGlobal(credStruct.UserName);
        Marshal.FreeHGlobal(credStruct.CredentialBlob);
    }

    public static Credential ReadCredential(string applicationName)
    {
        IntPtr credPtr;
        CredRead(applicationName, 1, 0, out credPtr);
        CREDENTIALW credStruct = (CREDENTIALW)Marshal.PtrToStructure(credPtr, typeof(CREDENTIALW));
        Credential cred = new Credential();
        cred.UserName = Marshal.PtrToStringUni(credStruct.UserName);
        cred.Password = Marshal.PtrToStringUni(credStruct.CredentialBlob, (int)credStruct.CredentialBlobSize / 2);
        CoTaskMemFree(credPtr);
        return cred;
    }

    public static void DeleteCredential(string applicationName)
    {
        CredDelete(applicationName, 1, 0);
    }
}

public enum CredentialPersistence
{
    Session = 1,
    LocalMachine = 2,
    Enterprise = 3
}

[TestClass]
public class CredentialTest
{
    [TestMethod]
    public void CredentialManagerTest()
    {
        CredentialManager.WriteCredential("ApplicationName", "username", "Pa$$w0rd", CredentialPersistence.Session);

        var cred = CredentialManager.ReadCredential("ApplicationName");
        Assert.AreEqual("username", cred.UserName);
        Assert.AreEqual("Pa$$w0rd", cred.Password);

        CredentialManager.DeleteCredential("ApplicationName");
    }
}