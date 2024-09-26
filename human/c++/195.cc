cpp
#include <cryptopp/aes.h>
#include <cryptopp/modes.h>
#include <cryptopp/filters.h>
#include <cryptopp/base64.h>

int main() {
    // Initialize the IV
    unsigned char iv[CryptoPP::AES::BLOCKSIZE];
    CryptoPP::ArraySink ivSink(iv, sizeof(iv));

    // Source
    CryptoPP::StringSource source("your_base64_encoded_string", true, new CryptoPP::Base64Decoder());

    // Attach and pump
    source.Attach(new CryptoPP::Redirector(ivSink));
    source.Pump(CryptoPP::AES::BLOCKSIZE);

    // Decrypt
    CryptoPP::AES::Decryption aesDecryption("your_key", CryptoPP::AES::DEFAULT_KEYLENGTH);
    CryptoPP::CBC_Mode_ExternalCipher::Decryption cbcDecryption(aesDecryption, iv);

    CryptoPP::StreamTransformationFilter stfDecryptor(cbcDecryption, new CryptoPP::StringSink("decrypted_string"));
    source.Attach(new CryptoPP::Redirector(stfDecryptor));
    source.PumpAll();

    return 0;
}