csharp
using System;
using System.Net.Http;
using System.Threading.Tasks;

class Program
{
    static async Task Main(string[] args)
    {
        using var client = new HttpClient();
        var response = await client.GetAsync("https://www.googleapis.com/oauth2/v2/tokeninfo?id_token=eyJhbGciOiJSUzI1NiIsImtpZCI6IjkyNGE0NjA2NDgxM2I5YTA5ZmFjZGJiNzYwZGI5OTMwMWU0ZjBkZjAifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwic3ViIjoiMTEwNTcwOTc3MjI2ODMwNTc3MjMwIiwiYXpwIjoiMzY0MzgxNDQxMzEwLXRuOGw2ZnY2OWdnOGY3a3VjanJhYTFyZWpmaXRxbGpuLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXRfaGFzaCI6IlAzLU1HZTdocWZhUkZ5Si1qcWRidHciLCJhdWQiOiIzNjQzODE0NDEzMTAtdG44bDZmdjY5Z2c4ZjdrdWNqcmFhMXJlamZpdHFsam4uYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJjX2hhc2giOiJjd3hsdXBUSkc4N2FnbU1pb0tSYUV3IiwiaWF0IjoxNDM0NDcyODc2LCJleHAiOjE0MzQ0NzY0NzZ9.Gz_WljZOV9NphDdClakLstutEKk65PNpEof7mxM2j-AOfVwh-SS0L5uxIaknFOk4-nDGmip42vrPYgNvbQWKZY63XuCs94YQgVVmTNCTJnao1IavtrhYvpDqGuGKdEB3Wemg5sS81pEthdvHwyxfwLPYukIhT8-u4ESfbFacsRtR77QRIOk-iLJAVYWTROJ05Gpa-EkTunEBVmZyYetbMfSoYkbwFKxYOlHLY-ENz_XfHTGhYhb-GyGrrw0r4FyHb81IWJ6Jf-7w6y3RiUJik7kYRkvnFouXUFSm8GBwxsioi9AAkavUWUk27s15Kcv-_hkPXzVrW5SvR1zoTI_IMw");

        Console.WriteLine(await response.Content.ReadAsStringAsync());
    }
}