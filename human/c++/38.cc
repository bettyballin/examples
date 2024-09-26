cpp
#include <cryptopp/base64.h>
#include <cryptopp/filters.h>
#include <cryptopp/aes.h>
#include <cryptopp/modes.h>
#include <cryptopp/queue.h>
#include <string>
#include <iostream>

int main() {
    std::string ciphertext = "your_ciphertext_here";
    std::string key = "your_key_here";
    std::string iv = "your_iv_here";
    std::string decryptedtext;

    CryptoPP::AES::Decryption aesDecryption((const byte*)key.c_str(), key.size());
    CryptoPP::CBC_Mode_ExternalCipher::Decryption cbcDecryption(aesDecryption, (const byte*)iv.c_str());

    CryptoPP::StreamTransformationFilter decryptor(cbcDecryption, NULL);

    CryptoPP::StringSource ss(ciphertext, true,
        new CryptoPP::HexDecoder(
            new CryptoPP::StreamTransformationFilter( decryptor,
                new CryptoPP::StringSink( decryptedtext ) ) ) );

    std::cout << decryptedtext << std::endl;

    return 0;
}