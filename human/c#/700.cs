csharp
using System;
using System.Net.Http;
using System.Net.Http.Headers;

class Program
{
    static void Main()
    {
        using (var client = new HttpClient())
        {
            client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6ImN1b25nIiwibmJmIjoxNDc3NTY1MjU4LCJleHAiOjE0Nzc1NjY0NTgsImlhdCI6MTQ3NzU2NTI1OH0.dSwwufd4-gztkLpttZsZ1255oEzpWCJkayR_4yvNL1s");
            var response = client.GetAsync($"http://localhost:5000/api/value").Result;
            Console.WriteLine(response.Content.ReadAsStringAsync().Result);
        }
    }
}