csharp
using System;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Parameters;
using Org.BouncyCastle.Crypto.Digests;
using Org.BouncyCastle.Crypto.Macs;
using Org.BouncyCastle.Math;
using Org.BouncyCastle.Security;

namespace PBKDF2_PKCS5
{
    class PBKDF2
    {

        private readonly IMac hMac = new HMac(new Sha1Digest());

        private void F(
            byte[] P,
            byte[] S,
            int c,
            byte[] iBuf,
            byte[] outBytes,
            int outOff)
        {
            byte[] state = new byte[hMac.GetMacSize()];
            ICipherParameters param = new KeyParameter(P);

            hMac.Init(param);

            if (S != null)
            {
                hMac.BlockUpdate(S, 0, S.Length);
            }

            hMac.BlockUpdate(iBuf, 0, iBuf.Length);

            hMac.DoFinal(state, 0);

            Array.Copy(state, 0, outBytes, outOff, state.Length);

            for (int count = 1; count != c; count++)
            {
                hMac.Init(param);
                hMac.BlockUpdate(state, 0, state.Length);
                hMac.DoFinal(state, 0);

                for (int j = 0; j != state.Length; j++)
                {
                    outBytes[outOff + j] ^= state[j];
                }
            }
        }

        private void IntToOctet(
            byte[] Buffer,
            int i)
        {
            Buffer[0] = (byte)((uint)i >> 24);
            Buffer[1] = (byte)((uint)i >> 16);
            Buffer[2] = (byte)((uint)i >> 8);
            Buffer[3] = (byte)i;
        }

        public byte[] GenerateDerivedKey(
            int dkLen,
            byte[] mPassword,
            byte[] mSalt,
            int mIterationCount
            )
        {
            int hLen = hMac.GetMacSize();
            int l = (dkLen + hLen - 1) / hLen;
            byte[] iBuf = new byte[4];
            byte[] outBytes = new byte[l * hLen];

            for (int i = 1; i <= l; i++)
            {
                IntToOctet(iBuf, i);

                F(mPassword, mSalt, mIterationCount, iBuf, outBytes, (i - 1) * hLen);
            }

            byte[] output = new byte[dkLen];
            Buffer.BlockCopy(outBytes, 0, output, 0, dkLen);
            return output;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            PBKDF2 pbkdf2 = new PBKDF2();
            string password = "password";
            string salt = "salt";
            int iterations = 1000;
            int keyLength = 20;

            byte[] passwordBytes = System.Text.Encoding.UTF8.GetBytes(password);
            byte[] saltBytes = System.Text.Encoding.UTF8.GetBytes(salt);

            byte[] derivedKey = pbkdf2.GenerateDerivedKey(keyLength, passwordBytes, saltBytes, iterations);

            Console.WriteLine(BitConverter.ToString(derivedKey));
        }
    }
}