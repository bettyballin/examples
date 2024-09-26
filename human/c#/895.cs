csharp
using System;

class Program
{
    private static byte[] ConvertX509PemToDer(string pemContents)
    {
        return Convert.FromBase64String(pemContents
            .TrimStart("-----BEGIN PUBLIC KEY-----".ToCharArray())
            .TrimEnd("-----END PUBLIC KEY-----".ToCharArray())
            .Replace("\r\n", ""));
    }

    static void Main()
    {
        string pemContents = "-----BEGIN PUBLIC KEY-----\r\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn1pMVSEDO4EPzQxKgAakFxRgMGiewWZFAktenWo5aMt/OIsoGCsHg7wB4hR4SnW70jGz9X4yP3Fm2HJeBaxvIapKdQKkYwV6k+T4mJYtEQ8wqW6RbQ\ncSkjrCjU3ZikS3KHYng7/zH1j3QIjFyq2NfHvQWKF6w2D1j0L6f5jQwZj6Nz1g7pG7mG0w3yZGyJcv8IJsWgO3yU5YqDj+7mFjgDJy+Lw3xwGu+XyUlfCxvM3xDRZV+M7jUoK2sFjULrW5yJ0h1yrQFg5LcT6YjH7+xO1P4xwIbj1X8bM8SxI4Bj2M9w8t9xOaQIjQdN7RdI9T4i8YjQdN7RdI9T4i8YrV+HkCkYwFoQkYwFoQkYwFoT6YjH7+xO1P4xwIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA\r\n-----END PUBLIC KEY-----";
        byte[] derContents = ConvertX509PemToDer(pemContents);
        Console.WriteLine(BitConverter.ToString(derContents));
    }
}