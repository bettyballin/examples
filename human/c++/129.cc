cpp
#include <cryptopp/cryptlib.h>
#include <cryptopp/rsa.h>
#include <cryptopp/integer.h>
#include <cryptopp/base64.h>
#include <cryptopp/filters.h>
#include <string>
#include <iostream>

int main() {
    // Set public key
    std::string publicKey = "your_base64_encoded_public_key";

    // Decode public key
    CryptoPP::RSA::PublicKey pbKeyDecoded;
    CryptoPP::StringSource ss2(publicKey, true, new CryptoPP::Base64Decoder(new CryptoPP::StringSink()));
    pbKeyDecoded.BERDecode(ss2);

    // Set plaintext
    std::string plaintext = "your_plaintext";

    // Encrypt plaintext
    CryptoPP::Integer m = CryptoPP::Integer((const byte*)plaintext.data(), plaintext.size());
    CryptoPP::Integer crypted = pbKeyDecoded.ApplyFunction(m);

    // Output result
    std::cout << "Encrypted: " << crypted << std::endl;

    return 0;
}