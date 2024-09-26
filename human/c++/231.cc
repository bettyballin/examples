cpp
#include <osrng.h>
#include <eccrypto.h>
#include <filters.h>
#include <files.h>
#include <string>
#include <iostream>

using namespace CryptoPP;
using namespace std;

int main() {
    // DER encoded PKCS#8 private key
    uint8_t server_priv_key_[] = {
        0x30, 0x77, 0x02, 0x01, 0x01, 0x04, 0x41, 0x04, 0x18, 0x3a, 0x3e, 0x5c, 0x6f, 0x63, 0x6f, 0x6c,
        0x61, 0x77, 0x6f, 0x65, 0x72, 0x74, 0x68, 0x69, 0x73, 0x69, 0x73, 0x74, 0x68, 0x65, 0x6b, 0x65,
        0x79, 0x03, 0x02, 0x00, 0x04, 0x00, 0x04, 0x01, 0x3f, 0x00, 0x04, 0x41, 0x04, 0x18, 0x3a, 0x3e,
        0x5c, 0x6f, 0x63, 0x6f, 0x6c, 0x61, 0x77, 0x6f, 0x65, 0x72, 0x74, 0x68, 0x69, 0x73, 0x69, 0x73,
        0x74, 0x68, 0x65, 0x6b, 0x65, 0x79, 0x03, 0x02, 0x00, 0x04, 0x00
    };

    // Import private key
    ArraySource server_priv_key_source{ server_priv_key_, sizeof(server_priv_key_), true };
    ECDSA<ECP, SHA256>::PrivateKey server_priv_key;
    server_priv_key.Load(server_priv_key_source);

    // Derive public key
    ECDSA<ECP, SHA256>::PublicKey publicKey;
    server_priv_key.MakePublicKey(publicKey);

    // Sign
    AutoSeededRandomPool prng;
    ECDSA<ECP, SHA256>::Signer signer(server_priv_key);
    size_t signatureLen = signer.MaxSignatureLength();
    string signature(signatureLen, 0x00);
    string msg = "The quick brown fox jumps over the lazy dog";
    signatureLen = signer.SignMessage(prng, (const byte*)&msg[0], msg.size(), (byte*)&signature[0]);
    signature.resize(signatureLen);

    // Verify
    ECDSA<ECP, SHA256>::Verifier verifier(publicKey);
    bool result = verifier.VerifyMessage((const byte*)&msg[0], msg.size(), (const byte*)&signature[0], signature.size());
    cout << (result ? "verified" : "failed") << endl;

    return 0;
}