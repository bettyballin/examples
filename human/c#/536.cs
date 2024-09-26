csharp
using System;
using System.Text;

class Program
{
    static void Main()
    {
        int maxLength = 3;

        for (int length = 1; length <= maxLength; ++length)
        {
            StringBuilder Sb = new StringBuilder(new String('a', length));

            while (true)
            {
                String value = Sb.ToString();
                Console.WriteLine(value); // Print the current combination

                if (value.All(item => item == 'z'))
                    break;

                for (int i = length - 1; i >= 0; --i)
                    if (Sb[i] != 'z')
                    {
                        Sb[i] = (Char)(Sb[i] + 1);
                        break;
                    }
                    else
                        Sb[i] = 'a';
            }
        }
    }
}