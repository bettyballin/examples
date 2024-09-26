csharp
using System;
using System.Linq;
using System.Security.Cryptography;
using System.Text;

namespace SandboxConsole
{
    public class FairDiceRollServer
    {
        private byte[] _sessionKey;
        private HMACSHA256 _hmac;

        public byte[] StartSession()
        {
            _sessionKey = new byte[32];
            using (var rng = RandomNumberGenerator.Create())
            {
                rng.GetBytes(_sessionKey);
            }
            _hmac = new HMACSHA256(_sessionKey);
            return _sessionKey;
        }

        public (byte[] HmacMessage, int Roll) RollDice(string key)
        {
            var roll = new byte[4];
            using (var rng = RandomNumberGenerator.Create())
            {
                rng.GetBytes(roll);
            }
            var rollValue = BitConverter.ToInt32(roll, 0) % 6 + 1;
            var message = Encoding.UTF8.GetBytes(key + rollValue.ToString());
            var hmacMessage = _hmac.ComputeHash(message);
            return (hmacMessage, rollValue);
        }

        public byte[] EndSession()
        {
            return _sessionKey;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            var server = new FairDiceRollServer();
            var hash = server.StartSession();
            Console.WriteLine(string.Join("", hash.Select(x => x.ToString("X2"))));
            for (int i = 0; i < 10; i++)
            {
                var roll = server.RollDice("My Key");
                Console.WriteLine("Message: {0} Result: {1}", string.Join("", roll.HmacMessage.Select(x => x.ToString("X2"))), roll.Roll);
            }
            var key = server.EndSession();
            Console.WriteLine(string.Join("", key.Select(x => x.ToString("X2"))));
            Console.ReadLine();
        }
    }
}