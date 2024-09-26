cpp
#include <cryptopp/rsa.h>
#include <cryptopp/oaep.h>
#include <cryptopp/sha.h>
#include <cryptopp/filters.h>
#include <cryptopp/base64.h>

#include <string>
#include <iostream>

int main() {
    using namespace CryptoPP;

    // Generate private key
    AutoSeededRandomPool rng;
    RSA::PrivateKey privateKey;
    privateKey.GenerateRandomWithKeySize(rng, 3072);

    // Encrypt a message
    RSAES_OAEP_SHA_Encryptor e(privateKey);
    std::string message = "Hello, World!";
    std::string cipher;
    StringSource(message, true,
        new PK_EncryptorFilter(rng, e,
            new StringSink(cipher)
        )
    );

    // Decrypt the message
    RSAES_OAEP_SHA_Decryptor d(privateKey);
    std::string recovered;
    StringSource(cipher, true,
        new PK_DecryptorFilter(rng, d,
            new StringSink(recovered)
        )
    );

    // Print the recovered message
    std::cout << "Recovered: " << recovered << std::endl;

    return 0;
}