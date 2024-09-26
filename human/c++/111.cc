cpp
#include <iostream>
#include <string>
#include <cryptopp/aes.h>
#include <cryptopp/modes.h>
#include <cryptopp/filters.h>
#include <cryptopp/base64.h>

int main() {
    std::string key = "0123456789abcdef";
    std::string iv = "0123456789abcdef";
    std::string plaintext = "Hello, World!";
    std::string ciphertext;
    std::string decryptedtext;

    CryptoPP::AES::Encryption aesEncryption((const byte*)key.c_str(), CryptoPP::AES::DEFAULT_KEYLENGTH);
    CryptoPP::CBC_Mode_ExternalCipher::Encryption cbcEncryption(aesEncryption, (const byte*)iv.c_str());

    CryptoPP::StreamTransformationFilter stfEncryptor(cbcEncryption, new CryptoPP::StringSink(ciphertext));
    stfEncryptor.Put((const byte*)plaintext.data(), plaintext.size());
    stfEncryptor.MessageEnd();

    CryptoPP::AES::Decryption aesDecryption((const byte*)key.c_str(), CryptoPP::AES::DEFAULT_KEYLENGTH);
    CryptoPP::CBC_Mode_ExternalCipher::Decryption cbcDecryption(aesDecryption, (const byte*)iv.c_str());

    CryptoPP::StreamTransformationFilter stfDecryptor(cbcDecryption, new CryptoPP::StringSink(decryptedtext));
    stfDecryptor.Put((const byte*)ciphertext.data(), ciphertext.size());
    stfDecryptor.MessageEnd();

    std::cout << "Plaintext: " << plaintext << std::endl;
    std::cout << "Ciphertext: " << std::hex;
    for (int i = 0; i < ciphertext.size(); i++) {
        std::cout << (int)ciphertext[i];
    }
    std::cout << std::endl;
    std::cout << "Decrypted text: " << decryptedtext << std::endl;

    return 0;
}