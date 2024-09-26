csharp
using System;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;
using System.Threading;

class Program
{
    static void Main(string[] args)
    {
        ThreadPool.UnsafeQueueUserWorkItem(ignoredState =>
        {
            Stream stream = null;
            try
            {
                stream = new FileStream("HighScores.dat", FileMode.Create, FileAccess.Write);
                BinaryFormatter b = new BinaryFormatter();
                b.Serialize(stream, "Test String");
            }
            catch (Exception e)
            {
                Console.Error.WriteLine("Error writing high scores: " + e.Message);
            }
            finally
            {
                if (stream != null)
                {
                    stream.Close();
                }
            }
        }, null);

        Thread.Sleep(1000); // wait for the thread to finish
    }
}