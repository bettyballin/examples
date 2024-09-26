csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class DesigntimeLicense : License
{
    public override void Dispose() { }
}

public class RuntimeLicense : License
{
    public override void Dispose() { }
}

public class LicenseException : Exception
{
    public LicenseException(Type type, object instance, string message) : base(message) { }
}

public class LicenseContext
{
    public LicenseUsageMode UsageMode { get; set; }
}

public enum LicenseUsageMode
{
    Designtime,
    Runtime
}

public class License
{
    public virtual void Dispose() { }
}

public class Licensing
{
    public License GetLicense(LicenseContext context, Type type, object instance, bool allowExceptions)
    {
        if (context.UsageMode == LicenseUsageMode.Designtime)
        {
            return new DesigntimeLicense();
        }

        byte[] existingSerialKey = GetExistingSerial();
        byte[] data = GetHashedData("username", DateTime.Now, DateTime.Now.AddDays(1));

        for (int l = 0; l < existingSerialKey.Length; ++l)
        {
            if (existingSerialKey[l] != data[l])
            {
                if (allowExceptions)
                {
                    throw new LicenseException(type, instance, "License is invalid");
                }
                return null;
            }
        }

        return new RuntimeLicense();
    }

    private byte[] GetExistingSerial()
    {
        // Replace with your implementation
        return new byte[] { 1, 2, 3, 4, 5 };
    }

    private byte[] GetHashedData(string username, DateTime dateRequested, DateTime validUntilDate)
    {
        using (var sha1 = new SHA1CryptoServiceProvider())
        {
            var data = string.Format("{0}{1}{2}", username, dateRequested, validUntilDate);
            return sha1.ComputeHash(Encoding.UTF8.GetBytes(data));
        }
    }
}