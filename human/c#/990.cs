Here is the equivalent C# code:

csharp
using System;
using System.Collections.Generic;
using System.IO;
using System.IO.Compression;
using System.Linq;
using System.Reflection;
using System.Text;

namespace com.technojeeves.shm
{
    public class Loader
    {
        private static readonly string JARENC = "UEsDBBQACAgIABqp8FIAAAAAAAAAAAAAAAAlAAQAY29tL3RlY2hub2plZXZlcy9zaG0vSGVsbG9Xb3JsZC5jbGFzc/7KAABtUMtOwkAUPZdXaa2CIPgkwsIEXNiNO4wbE+OCqAkGF65KmcCQtmPKgPGzdKGJCz/AjzLeaUzQhFncx5nzSO7X98cngFM0HGSQtZBzkUeBUJ76C98L/Xjs3QynItCEwpmMpT4nZNudgY0ibAuOizW4/+j955kWEbPUnEW1XvojlXebyFj3dSL8qFvEBsG9EmGomk8qCUctB2VsWqi4qGKLUF2hIliPZgtjtm33/iRqhsfdzsBCnXAYqMjTIpjEairEQsy82STy0qx7E0XIXaiRIJR6MhbX82gokjt/GDKSi3zJ5vX2wyp3gtNX8yQQl9KQS0vLE8NGCzW+oXkZkLki123eGtyJe/74HfTCA2GHayEFs7Cxi71f6lEqBexXWJX1N5SWdCf1zvPZjXA/TTn4AVBLBwhqV5QAMQEAAL8BAABQSwECFAAUAAgICAAaqfBSaleUADEBAAC/AQAAJQAEAAAAAAAAAAAAAAAAAAAAY29tL3RlY2hub2plZXZlcy9zaG0vSGVsbG9Xb3JsZC5jbGFzc/7KAABQSwUGAAAAAAEAAQBXAAAAiAEAAAAA";

        public static void Main(string[] args)
        {
            try
            {
                byte[] jarBytes = Convert.FromBase64String(JARENC);
                RemoteClassLoader memJarLoader = new RemoteClassLoader(jarBytes);
                Type hw = memJarLoader.LoadType("com.technojeeves.shm.HelloWorld");
                MethodInfo main = hw.GetMethod("Main", BindingFlags.Public | BindingFlags.Static, new Type[] { typeof(string[]) });
                string[] parameters = null;
                main.Invoke(null, new object[] { parameters });
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
            }
        }
    }

    public class RemoteClassLoader : MarshalByRefObject
    {
        private readonly byte[] jarBytes;
        private readonly HashSet<string> names;

        public RemoteClassLoader(byte[] jarBytes)
        {
            this.jarBytes = jarBytes;
            this.names = RemoteClassLoader.LoadNames(jarBytes);
        }

        private static HashSet<string> LoadNames(byte[] jarBytes)
        {
            HashSet<string> set = new HashSet<string>();
            using (MemoryStream ms = new MemoryStream(jarBytes))
            {
                using (ZipArchive archive = new ZipArchive(ms, ZipArchiveMode.Read))
                {
                    foreach (ZipArchiveEntry entry in archive.Entries)
                    {
                        set.Add(entry.FullName);
                    }
                }
            }
            return set;
        }

        public Type LoadType(string name)
        {
            Type type = null;
            string toLoad = name.Replace('.', '/') + ".class";
            if (names.Contains(toLoad))
            {
                using (MemoryStream ms = new MemoryStream(jarBytes))
                {
                    using (ZipArchive archive = new ZipArchive(ms, ZipArchiveMode.Read))
                    {
                        ZipArchiveEntry entry = archive.Entries.FirstOrDefault(e => e.FullName == toLoad);
                        if (entry != null)
                        {
                            using (Stream stream = entry.Open())
                            {
                                byte[] bytes = ReadStream(stream);
                                Assembly assembly = Assembly.Load(bytes);
                                type = assembly.GetType(name);
                            }
                        }
                    }
                }
            }
            return type;
        }

        private static byte[] ReadStream(Stream stream)
        {
            byte[] buffer = new byte[16 * 1024];
            using (MemoryStream ms = new MemoryStream())
            {
                int read;
                while ((read = stream.Read(buffer, 0, buffer.Length)) > 0)
                {
                    ms.Write(buffer, 0, read);
                }
                return ms.ToArray();
            }
        }
    }
}