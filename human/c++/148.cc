cpp
#include <cryptopp/cryptlib.h>
#include <cryptopp/filters.h>
#include <cryptopp/base64.h>
#include <cryptopp/dsa.h>
#include <cryptopp/rsa.h>

int main() {
    using namespace CryptoPP;

    // Generate a random key for demonstration purposes
    AutoSeededRandomPool rng;
    RSA::PrivateKey key;
    key.GenerateRandomWithKeySize(rng, 2048);

    // Create a StringSource from the key
    std::string keyStr;
    StringSink sink(keyStr);
    key.Save(sink);

    StringSource ss(keyStr, true, new PKCS8Decode());

    // Create a signer and load the key
    RSASSA_PKCS1v15_SHA_Signer signer;
    signer.AccessKey().Load(ss);

    return 0;
}