csharp
using System;
using System.IO;
using System.Threading.Tasks;
using Windows.Storage.Streams;

public static class BufferExtensions
{
  public async static Task ClearContentsAsync(this IBuffer buff)
  {
    var writer = new DataWriter(buff.AsStream().AsOutputStream());
    for (var i = 0; i < buff.Capacity; i++)
      writer.WriteByte(42);
    await writer.StoreAsync();
  }
}

class Program
{
  static async Task Main(string[] args)
  {
    var buffer = new Windows.Storage.Streams.Buffer(10);
    await BufferExtensions.ClearContentsAsync(buffer);
  }
}