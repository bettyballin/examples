csharp
using System;

class Program
{
    public static byte[] Concat(byte[] arr1, byte[] arr2)
    {
        byte[] newArr = new byte[arr1.Length + arr2.Length];
        Buffer.BlockCopy(arr1, 0, newArr, 0, arr1.Length);
        Buffer.BlockCopy(arr2, 0, newArr, arr1.Length, arr2.Length);
        return newArr;
    }

    static void Main(string[] args)
    {
        byte[] arr1 = { 1, 2, 3 };
        byte[] arr2 = { 4, 5, 6 };

        byte[] result = Concat(arr1, arr2);

        Console.WriteLine(string.Join(", ", result));
    }
}