csharp
using System;
using System.IO;

public class ProtectedStream : Stream
{
  private Stream stream;

  public ProtectedStream(Stream stream)
  {
    if(stream == null)
      throw new ArgumentNullException("stream");

    this.stream = stream;
  }

  public override void Close()
  {
    this.stream.Close();
    base.Close();
  }

  public override int Read(byte[] buffer, int offset, int count)
  {
    return this.stream.Read(buffer, offset, count);
  }

  public override void Write(byte[] buffer, int offset, int count)
  {
    this.stream.Write(buffer, offset, count);
  }

  public override void Flush()
  {
    this.stream.Flush();
  }

  public override long Seek(long offset, SeekOrigin origin)
  {
    return this.stream.Seek(offset, origin);
  }

  public override void SetLength(long value)
  {
    this.stream.SetLength(value);
  }

  public override bool CanRead
  {
    get { return this.stream.CanRead; }
  }

  public override bool CanWrite
  {
    get { return this.stream.CanWrite; }
  }

  public override bool CanSeek
  {
    get { return this.stream.CanSeek; }
  }

  public override long Length
  {
    get { return this.stream.Length; }
  }

  public override long Position
  {
    get { return this.stream.Position; }
    set { this.stream.Position = value; }
  }

  public override IAsyncResult BeginRead(byte[] buffer, int offset, int count, AsyncCallback callback, object state)
  {
    return this.stream.BeginRead(buffer, offset, count, callback, state);
  }

  public override int EndRead(IAsyncResult asyncResult)
  {
    return this.stream.EndRead(asyncResult);
  }

  public override IAsyncResult BeginWrite(byte[] buffer, int offset, int count, AsyncCallback callback, object state)
  {
    return this.stream.BeginWrite(buffer, offset, count, callback, state);
  }

  public override void EndWrite(IAsyncResult asyncResult)
  {
    this.stream.EndWrite(asyncResult);
  }

  public override void Dispose()
  {
    this.stream.Dispose();
    base.Dispose();
  }
}

class Program
{
  static void Main()
  {
    using (var stream = new ProtectedStream(new MemoryStream()))
    {
      stream.Write(new byte[] { 1, 2, 3 }, 0, 3);
      stream.Position = 0;
      var buffer = new byte[3];
      stream.Read(buffer, 0, 3);
      foreach (var b in buffer)
      {
        Console.Write(b + " ");
      }
    }
  }
}