cpp
#include <cryptopp/aes.h>
#include <cryptopp/modes.h>
#include <cryptopp/filters.h>

#include <string>

int main() {
    std::string key = "0123456789abcdef";
    std::string iv = "0123456789abcdef";

    CryptoPP::AES::Encryption aes((const byte*)key.c_str(), key.size());
    CryptoPP::CBC_Mode_ExternalCipher::Encryption cbc(aes, (const byte*)iv.c_str());

    return 0;
}