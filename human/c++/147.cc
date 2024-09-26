cpp
#include <cryptopp/cryptlib.h>
#include <cryptopp/files.h>
#include <cryptopp/filters.h>
#include <cryptopp/base64.h>
#include <cryptopp/rsa.h>
#include <cryptopp/pssr.h>

int main() {
    std::string key = "your_key_here";
    CryptoPP::StringSink ss(key);
    CryptoPP::RSASSA_PKCS1v15_SHA_Signer signer;
    signer.AccessKey().Load(ss);
    return 0;
}