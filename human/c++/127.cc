cpp
#include <cryptopp/osrng.h>
#include <cryptopp/rsa.h>
#include <cryptopp/filters.h>
#include <cryptopp/base64.h>

#include <string>
using namespace std;
using namespace CryptoPP;

int main() {
    AutoSeededRandomPool rng;

    // Generate keys
    RSA::PrivateKey privateKey;
    privateKey.GenerateRandomWithKeySize(rng, 2048);
    RSA::PublicKey publicKey(privateKey);

    string message = "Hello, World!";
    RSAES_OAEP_SHA_Encryptor e(publicKey);
    string cipher;

    StringSource stringSource(message, true,
        new PK_EncryptorFilter(rng, e,
            new StringSink(cipher)
        )
    );

    // Example: Print the encrypted text
    StringSource(cipher, true, new HexEncoder(new FileSink(cout)));

    return 0;
}