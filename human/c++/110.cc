cpp
#include <iostream>
#include <string>
#include <cryptopp/aes.h>
#include <cryptopp/modes.h>
#include <cryptopp/filters.h>

int main() {
    std::string plain = "Now is the time for all good men to come to the aide of their country";
    std::string cipher, recover;

    CryptoPP::AES::Encryption aesEncryption(CryptoPP::AES::DEFAULT_KEYLENGTH);
    CryptoPP::CBC_Mode_ExternalCipher::Encryption cbcEncryption(aesEncryption, CryptoPP::IV_128(0));

    CryptoPP::StringSink* sink = new CryptoPP::StringSink(cipher);
    CryptoPP::StreamTransformationFilter* filter = new CryptoPP::StreamTransformationFilter(cbcEncryption, sink);

    filter->Put((const byte*)plain.data(), plain.size());
    filter->MessageEnd();

    CryptoPP::AES::Decryption aesDecryption(CryptoPP::AES::DEFAULT_KEYLENGTH);
    CryptoPP::CBC_Mode_ExternalCipher::Decryption cbcDecryption(aesDecryption, CryptoPP::IV_128(0));

    CryptoPP::StringSink* recoverSink = new CryptoPP::StringSink(recover);
    CryptoPP::StreamTransformationFilter* recoverFilter = new CryptoPP::StreamTransformationFilter(cbcDecryption, recoverSink);

    recoverFilter->Put((const byte*)cipher.data(), cipher.size());
    recoverFilter->MessageEnd();

    std::cout << "Plain: " << plain << std::endl;
    std::cout << "Recover: " << recover << std::endl;

    return 0;
}