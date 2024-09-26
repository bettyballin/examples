csharp
using System;
using System.IO;

public static class StreamExtensions
{
    public static string Text(this Stream stream)
    {
        stream.Position = 0;
        using (var reader = new StreamReader(stream))
        {
            return reader.ReadToEnd();
        }
    }
}