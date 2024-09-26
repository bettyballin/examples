cpp
// test.cxx
#include "cryptopp/aes.h"
#include "cryptopp/modes.h"
#include "cryptopp/filters.h"

int main() {
    using namespace CryptoPP;

    // Set key and IV
    std::string key = "0123456789abcdef";
    std::string iv = "0123456789abcdef";

    // Create AES encryptor
    AES::Encryption aesEncryption(key, key.size());
    CBC_Mode_ExternalCipher::Encryption cbcEncryption(aesEncryption, iv);

    // Set plaintext
    std::string plaintext = "Hello, World!";

    // Encrypt
    std::string ciphertext;
    StreamTransformationFilter stfEncryptor(cbcEncryption, new StringSink(ciphertext));
    stfEncryptor.Put((const byte*)plaintext.data(), plaintext.size());
    stfEncryptor.MessageEnd();

    // Print ciphertext
    std::cout << "Ciphertext: " << ciphertext << std::endl;

    // Create AES decryptor
    AES::Decryption aesDecryption(key, key.size());
    CBC_Mode_ExternalCipher::Decryption cbcDecryption(aesDecryption, iv);

    // Decrypt
    std::string decryptedtext;
    StreamTransformationFilter stfDecryptor(cbcDecryption, new StringSink(decryptedtext));
    stfDecryptor.Put((const byte*)ciphertext.data(), ciphertext.size());
    stfDecryptor.MessageEnd();

    // Print decrypted text
    std::cout << "Decrypted Text: " << decryptedtext << std::endl;

    return 0;
}