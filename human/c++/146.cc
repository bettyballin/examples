cpp
#include <cryptopp/cryptlib.h>
#include <cryptopp/rsa.h>
#include <cryptopp/files.h>
#include <cryptopp/base64.h>
#include <string>

int main() {
    using namespace CryptoPP;

    // Create a private key
    RSA::PrivateKey privateKey;
    privateKey.GenerateRandomWithKeySize(prng, 2048);

    // Create a signer
    RSASSA_PKCS1v15_SHA_Signer signer(privateKey);

    // Create a string to store the private key
    std::string p_key;

    // Create a StringSink object
    StringSink pss(p_key);

    // Save the private key to the StringSink
    signer.AccessKey().Save(pss);

    return 0;
}