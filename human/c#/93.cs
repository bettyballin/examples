Here is the executable code:

csharp
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;
using System.Runtime.InteropServices;
using System.ComponentModel;

namespace LargeCMS
{
    class CMS
    {
        // File stream to use in callback function
        private FileStream m_callbackFile;

        // Streaming callback function for encoding
        private Boolean StreamOutputCallback(IntPtr pvArg, IntPtr pbData, int cbData, Boolean fFinal)
        {
            // Write all bytes to encoded file
            Byte[] bytes = new Byte[cbData];
            Marshal.Copy(pbData, bytes, 0, cbData);
            m_callbackFile.Write(bytes, 0, cbData);

            if (fFinal)
            {
                // This is the last piece. Close the file
                m_callbackFile.Flush();
                m_callbackFile.Close();
                m_callbackFile = null;
            }

            return true;
        }

        // Encode CMS with streaming to support large data
        public void Encode(X509Certificate2 cert, FileStream inFile, FileStream outFile)
        {
            // Variables
            Win32.CMSG_SIGNER_ENCODE_INFO SignerInfo;
            Win32.CMSG_SIGNED_ENCODE_INFO SignedInfo;
            Win32.CMSG_STREAM_INFO StreamInfo;
            Win32.CERT_CONTEXT[] CertContexts = null;
            Win32.BLOB[] CertBlobs;

            X509Chain chain = null;
            X509ChainElement[] chainElements = null;
            X509Certificate2[] certs = null;
            RSACryptoServiceProvider key = null;
            BinaryReader stream = null;
            GCHandle gchandle = new GCHandle();

            IntPtr hProv = IntPtr.Zero;
            IntPtr SignerInfoPtr = IntPtr.Zero;
            IntPtr CertBlobsPtr = IntPtr.Zero;
            IntPtr hMsg = IntPtr.Zero;
            IntPtr pbPtr = IntPtr.Zero;
            Byte[] pbData;
            int dwFileSize;
            int dwRemaining;
            int dwSize;
            Boolean bResult = false;

            try
            {
                // Get data to encode
                dwFileSize = (int)inFile.Length;
                stream = new BinaryReader(inFile);
                pbData = stream.ReadBytes(dwFileSize);

                // Prepare stream for encoded info
                m_callbackFile = outFile;

                // Get cert chain
                chain = new X509Chain();
                chain.Build(cert);
                chainElements = new X509ChainElement[chain.ChainElements.Count];
                chain.ChainElements.CopyTo(chainElements, 0);

                // Get certs in chain
                certs = new X509Certificate2[chainElements.Length];
                for (int i = 0; i < chainElements.Length; i++)
                {
                    certs[i] = chainElements[i].Certificate;
                }

                // Get context of all certs in chain
                CertContexts = new Win32.CERT_CONTEXT[certs.Length];
                for (int i = 0; i < certs.Length; i++)
                {
                    CertContexts[i] = (Win32.CERT_CONTEXT)Marshal.PtrToStructure(certs[i].Handle, typeof(Win32.CERT_CONTEXT));
                }

                // Get cert blob of all certs
                CertBlobs = new Win32.BLOB[CertContexts.Length];
                for (int i = 0; i < CertContexts.Length; i++)
                {
                    CertBlobs[i].cbData = CertContexts[i].cbCertEncoded;
                    CertBlobs[i].pbData = CertContexts[i].pbCertEncoded;
                }

                // Get CSP of client certificate
                key = (RSACryptoServiceProvider)certs[0].PrivateKey;

                bResult = Win32.CryptAcquireContext(
                    ref hProv,
                    key.CspKeyContainerInfo.KeyContainerName,
                    key.CspKeyContainerInfo.ProviderName,
                    key.CspKeyContainerInfo.ProviderType,
                    0
                );
                if (!bResult)
                {
                    throw new Exception("CryptAcquireContext error #" + Marshal.GetLastWin32Error().ToString(), new Win32Exception(Marshal.GetLastWin32Error()));
                }

                // Populate Signer Info struct
                SignerInfo = new Win32.CMSG_SIGNER_ENCODE_INFO();
                SignerInfo.cbSize = Marshal.SizeOf(SignerInfo);
                SignerInfo.pCertInfo = CertContexts[0].pCertInfo;
                SignerInfo.hCryptProvOrhNCryptKey = hProv;
                SignerInfo.dwKeySpec = (int)key.CspKeyContainerInfo.KeyNumber;
                SignerInfo.HashAlgorithm.pszObjId = Win32.szOID_OIWSEC_sha1;

                // Populate Signed Info struct
                SignedInfo = new Win32.CMSG_SIGNED_ENCODE_INFO();
                SignedInfo.cbSize = Marshal.SizeOf(SignedInfo);

                SignedInfo.cSigners = 1;
                SignerInfoPtr = Marshal.AllocHGlobal(Marshal.SizeOf(SignerInfo));
                Marshal.StructureToPtr(SignerInfo, SignerInfoPtr, false);
                SignedInfo.rgSigners = SignerInfoPtr;

                SignedInfo.cCertEncoded = CertBlobs.Length;
                CertBlobsPtr = Marshal.AllocHGlobal(Marshal.SizeOf(CertBlobs[0]) * CertBlobs.Length);
                for (int i = 0; i < CertBlobs.Length; i++)
                {
                    Marshal.StructureToPtr(CertBlobs[i], new IntPtr(CertBlobsPtr.ToInt64() + (Marshal.SizeOf(CertBlobs[i]) * i)), false);
                }
                SignedInfo.rgCertEncoded = CertBlobsPtr;

                // Populate Stream Info struct
                StreamInfo = new Win32.CMSG_STREAM_INFO();
                StreamInfo.cbContent = dwFileSize;
                StreamInfo.pfnStreamOutput = new Win32.StreamOutputCallbackDelegate(StreamOutputCallback);

                // Open message to encode
                hMsg = Win32.CryptMsgOpenToEncode(
                    Win32.X509_ASN_ENCODING | Win32.PKCS_7_ASN_ENCODING,
                    0,
                    Win32.CMSG_SIGNED,
                    ref SignedInfo,
                    null,
                    ref StreamInfo
                );
                if (hMsg.Equals(IntPtr.Zero))
                {
                    throw new Exception("CryptMsgOpenToEncode error #" + Marshal.GetLastWin32Error().ToString(), new Win32Exception(Marshal.GetLastWin32Error()));
                }

                // Process the whole message
                gchandle = GCHandle.Alloc(pbData, GCHandleType.Pinned);
                pbPtr = gchandle.AddrOfPinnedObject();
                dwRemaining = dwFileSize;
                dwSize = (dwFileSize < 1024 * 1000 * 100) ? dwFileSize : 1024 * 1000 * 100;
                while (dwRemaining > 0)
                {
                    // Update message piece by piece
                    bResult = Win32.CryptMsgUpdate(
                        hMsg,
                        pbPtr,
                        dwSize,
                        (dwRemaining <= dwSize) ? true : false
                    );
                    if (!bResult)
                    {
                        throw new Exception("CryptMsgUpdate error #" + Marshal.GetLastWin32Error().ToString(), new Win32Exception(Marshal.GetLastWin32Error()));
                    }

                    // Move to the next piece
                    pbPtr = new IntPtr(pbPtr.ToInt64() + dwSize);
                    dwRemaining -= dwSize;
                    if (dwRemaining < dwSize)
                    {
                        dwSize = dwRemaining;
                    }
                }
            }
            finally
            {
                // Clean up
                if (gchandle.IsAllocated)
                {
                    gchandle.Free();
                }
                if (stream != null)
                {
                    stream.Close();
                }
                if (m_callbackFile != null)
                {
                    m_callbackFile.Close();
                }
                if (!CertBlobsPtr.Equals(IntPtr.Zero))
                {
                    Marshal.FreeHGlobal(CertBlobsPtr);
                }

                if (!SignerInfoPtr.Equals(IntPtr.Zero))
                {
                    Marshal.FreeHGlobal(SignerInfoPtr);
                }
                if (!hProv.Equals(IntPtr.Zero))
                {
                    Win32.CryptReleaseContext(hProv, 0);
                }
                if (!hMsg.Equals(IntPtr.Zero))
                {
                    Win32.CryptMsgClose(hMsg);
                }
            }
        }

        // Decode CMS with streaming to support large data
        public void Decode(FileStream inFile, FileStream outFile)
        {
            // Variables
            Win32.CMSG_STREAM_INFO StreamInfo;
            Win32.CERT_CONTEXT SignerCertContext;

            BinaryReader stream = null;
            GCHandle gchandle = new GCHandle();

            IntPtr hMsg = IntPtr.Zero;
            IntPtr pSignerCertInfo = IntPtr.Zero;
            IntPtr pSignerCertContext = IntPtr.Zero;
            IntPtr pbPtr = IntPtr.Zero;
            IntPtr hStore = IntPtr.Zero;
            Byte[] pbData;
            Boolean bResult = false;
            int dwFileSize;
            int dwRemaining;
            int dwSize;
            int cbSignerCertInfo;

            try
            {
                // Get data to decode
                dwFileSize = (int)inFile.Length;
                stream = new BinaryReader(inFile);
                pbData = stream.ReadBytes(dwFileSize);

                // Prepare stream for decoded info
                m_callbackFile = outFile;

                // Populate Stream Info struct
                StreamInfo = new Win32.CMSG_STREAM_INFO();
                StreamInfo.cbContent = dwFileSize;
                StreamInfo.pfnStreamOutput = new Win32.StreamOutputCallbackDelegate(StreamOutputCallback);

                // Open message to decode
                hMsg = Win32.CryptMsgOpenToDecode(
                    Win32.X509_ASN_ENCODING | Win32.PKCS_7_ASN_ENCODING,
                    0,
                    0,
                    IntPtr.Zero,
                    IntPtr.Zero,
                    ref StreamInfo
                );
                if (hMsg.Equals(IntPtr.Zero))
                {
                    throw new Exception("CryptMsgOpenToDecode error #" + Marshal.GetLastWin32Error().ToString(), new Win32Exception(Marshal.GetLastWin32Error()));
                }

                // Process the whole message
                gchandle = GCHandle.Alloc(pbData, GCHandleType.Pinned);
                pbPtr = gchandle.AddrOfPinnedObject();
                dwRemaining = dwFileSize;
                dwSize = (dwFileSize < 1024 * 1000 * 100) ? dwFileSize : 1024 * 1000 * 100;
                while (dwRemaining > 0)
                {
                    // Update message piece by piece
                    bResult = Win32.CryptMsgUpdate(
                        hMsg,
                        pbPtr,
                        dwSize,
                        (dwRemaining <= dwSize) ? true : false
                    );
                    if (!bResult)
                    {
                        throw new Exception("CryptMsgUpdate error #" + Marshal.GetLastWin32Error().ToString(), new Win32Exception(Marshal.GetLastWin32Error()));
                    }

                    // Move to the next piece
                    pbPtr = new IntPtr(pbPtr.ToInt64() + dwSize);
                    dwRemaining -= dwSize;
                    if (dwRemaining < dwSize)
                    {
                        dwSize = dwRemaining;
                    }
                }

                // Get signer certificate info
                cbSignerCertInfo = 0;
                bResult = Win32.CryptMsgGetParam(
                    hMsg,
                    Win32.CMSG_SIGNER_CERT_INFO_PARAM,
                    0,
                    IntPtr.Zero,
                    ref cbSignerCertInfo
                );
                if (!bResult)
                {
                    throw new Exception("CryptMsgGetParam error #" + Marshal.GetLastWin32Error().ToString(), new Win32Exception(Marshal.GetLastWin32Error()));
                }

                pSignerCertInfo = Marshal.AllocHGlobal(cbSignerCertInfo);

                bResult = Win32.CryptMsgGetParam(
                    hMsg,
                    Win32.CMSG_SIGNER_CERT_INFO_PARAM,
                    0,
                    pSignerCertInfo,
                    ref cbSignerCertInfo
                );
                if (!bResult)
                {
                    throw new Exception("CryptMsgGetParam error #" + Marshal.GetLastWin32Error().ToString(), new Win32Exception(Marshal.GetLastWin32Error()));
                }

                // Open a cert store in memory with the certs from the message
                hStore = Win32.CertOpenStore(
                    Win32.CERT_STORE_PROV_MSG,
                    Win32.X509_ASN_ENCODING | Win32.PKCS_7_ASN_ENCODING,
                    IntPtr.Zero,
                    0,
                    hMsg
                );
                if (hStore.Equals(IntPtr.Zero))
                {
                    throw new Exception("CertOpenStore error #" + Marshal.GetLastWin32Error().ToString(), new Win32Exception(Marshal.GetLastWin32Error()));
                }

                // Find the signer's cert in the store
                pSignerCertContext = Win32.CertGetSubjectCertificateFromStore(
                    hStore,
                    Win32.X509_ASN_ENCODING | Win32.PKCS_7_ASN_ENCODING,
                    pSignerCertInfo
                );
                if (pSignerCertContext.Equals(IntPtr.Zero))
                {
                    throw new Exception("CertGetSubjectCertificateFromStore error #" + Marshal.GetLastWin32Error().ToString(), new Win32Exception(Marshal.GetLastWin32Error()));
                }

                // Set message for verifying
                SignerCertContext = (Win32.CERT_CONTEXT)Marshal.PtrToStructure(pSignerCertContext, typeof(Win32.CERT_CONTEXT));
                bResult = Win32.CryptMsgControl(
                    hMsg,
                    0,
                    Win32.CMSG_CTRL_VERIFY_SIGNATURE,
                    SignerCertContext.pCertInfo
                );
                if (!bResult)
                {
                    throw new Exception("CryptMsgControl error #" + Marshal.GetLastWin32Error().ToString(), new Win32Exception(Marshal.GetLastWin32Error()));
                }
            }
            finally
            {
                // Clean up
                if (gchandle.IsAllocated)
                {
                    gchandle.Free();
                }
                if (!pSignerCertContext.Equals(IntPtr.Zero))
                {
                    Win32.CertFreeCertificateContext(pSignerCertContext);
                }
                if (!pSignerCertInfo.Equals(IntPtr.Zero))
                {
                    Marshal.FreeHGlobal(pSignerCertInfo);
                }
                if (!hStore.Equals(IntPtr.Zero))
                {
                    Win32.CertCloseStore(hStore, Win32.CERT_CLOSE_STORE_FORCE_FLAG);
                }
                if (stream != null)
                {
                    stream.Close();
                }
                if (m_callbackFile != null)
                {
                    m_callbackFile.Close();
                }
                if (!hMsg.Equals(IntPtr.Zero))
                {
                    Win32.CryptMsgClose(hMsg);
                }
            }
        }
    }

    public class Win32
    {
        [DllImport("advapi32.dll", CharSet = CharSet.Ansi, SetLastError = true)]
        public static extern bool CryptAcquireContext(ref IntPtr hProv, string szContainer, string szProvider, int dwProvType, int dwFlags);

        [DllImport("advapi32.dll", CharSet = CharSet.Ansi, SetLastError = true)]
        public static extern bool CryptReleaseContext(IntPtr hProv, int dwFlags);

        [DllImport("advapi32.dll", CharSet = CharSet.Ansi, SetLastError = true)]
        public static extern bool CryptMsgOpenToEncode(int dwMsgEncodingType, int dwFlags, int dwMsgType, ref CMSG_SIGNED_ENCODE_INFO pvMsgEncodeInfo, string pszInnerContentObjID, ref CMSG_STREAM_INFO pStreamInfo);

        [DllImport("advapi32.dll", CharSet = CharSet.Ansi, SetLastError = true)]
        public static extern bool CryptMsgUpdate(IntPtr hCryptMsg, IntPtr pbData, int cbData, bool fFinal);

        [DllImport("advapi32.dll", CharSet = CharSet.Ansi, SetLastError = true)]
        public static extern bool CryptMsgClose(IntPtr hCryptMsg);

        [DllImport("advapi32.dll", CharSet = CharSet.Ansi, SetLastError = true)]
        public static extern bool CryptMsgGetParam(IntPtr hCryptMsg, int dwParamType, int dwIndex, IntPtr pvData, ref int pcbData);

        [DllImport("advapi32.dll", CharSet = CharSet.Ansi, SetLastError = true)]
        public static extern IntPtr CertOpenStore(int lpszStoreProvider, int dwMsgAndCertEncodingType, IntPtr hCryptProv, int dwFlags, IntPtr pvPara);

        [DllImport("advapi32.dll", CharSet = CharSet.Ansi, SetLastError = true)]
        public static extern IntPtr CertGetSubjectCertificateFromStore(IntPtr hCertStore, int dwCertEncodingType, IntPtr pSignerId);

        [DllImport("advapi32.dll", CharSet = CharSet.Ansi, SetLastError = true)]
        public static extern bool CertFreeCertificateContext(IntPtr pCertContext);

        [DllImport("advapi32.dll", CharSet = CharSet.Ansi, SetLastError = true)]
        public static extern bool CertCloseStore(IntPtr hCertStore, int dwFlags);

        [DllImport("advapi32.dll", CharSet = CharSet.Ansi, SetLastError = true)]
        public static extern bool CryptMsgControl(IntPtr hCryptMsg, int dwFlags, int dwCtrlType, IntPtr pvCtrlPara);

        public const int X509_ASN_ENCODING = 0x00000001;
        public const int PKCS_7_ASN_ENCODING = 0x00010000;

        public const int CMSG_SIGNED = 2;

        public const int CMSG_SIGNER_CERT_INFO_PARAM = 3;

        public const int CERT_STORE_PROV_MSG = 1;

        public const int CERT_CLOSE_STORE_FORCE_FLAG = 0x00000001;

        public const int CMSG_CTRL_VERIFY_SIGNATURE = 1;

        public const int szOID_OIWSEC_sha1 = 4;

        public const string szOID_RSA_SHA1RSA = "1.2.840.113549.1.1.5";

        [StructLayout(LayoutKind.Sequential)]
        public struct CMSG_STREAM_INFO
        {
            public int cbContent;
            public StreamOutputCallbackDelegate pfnStreamOutput;
        }

        [StructLayout(LayoutKind.Sequential)]
        public struct CMSG_SIGNED_ENCODE_INFO
        {
            public int cbSize;
            public int cSigners;
            public IntPtr rgSigners;
            public int cCertEncoded;
            public IntPtr rgCertEncoded;
        }

        [StructLayout(LayoutKind.Sequential)]
        public struct CMSG_SIGNER_ENCODE_INFO
        {
            public int cbSize;
            public IntPtr pCertInfo;
            public IntPtr hCryptProvOrhNCryptKey;
            public int dwKeySpec;
            public CRYPT_ALGORITHM_IDENTIFIER HashAlgorithm;
            public IntPtr pvHashAuxInfo;
        }

        [StructLayout(LayoutKind.Sequential)]
        public struct CRYPT_ALGORITHM_IDENTIFIER
        {
            public IntPtr pszObjId;
            public BLOB Parameters;
        }

        [StructLayout(LayoutKind.Sequential)]
        public struct BLOB
        {
            public int cbData;
            public IntPtr pbData;
        }

        [StructLayout(LayoutKind.Sequential)]
        public struct CERT_CONTEXT
        {
            public int dwCertEncodingType;
            public IntPtr pbCertEncoded;
            public int cbCertEncoded;
            public IntPtr pCertInfo;
            public IntPtr hCertStore;
        }

        public delegate bool StreamOutputCallbackDelegate(IntPtr pvArg, IntPtr pbData, int cbData, bool fFinal);
    }

    class Program
    {
        static void Main()
        {
            CMS cms = new CMS();
            X509Certificate2 cert = new X509Certificate2("path_to_your_certificate");

            using (FileStream inFile = File.OpenRead("input_file"))
            {
                using (FileStream outFile = File.Create("output_file"))
                {
                    cms.Encode(cert, inFile, outFile);
                }
            }

            using (FileStream inFile = File.OpenRead("output_file"))
            {
                using (FileStream outFile = File.Create("decoded_file"))
                {
                    cms.Decode(inFile, outFile);
                }
            }
        }
    }
}