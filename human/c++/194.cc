cpp
#include <cryptopp/aes.h>
#include <cryptopp/modes.h>
#include <cryptopp/filters.h>

int main() {
    // Set key and initialization vector
    const unsigned char key[] = { /* your key here */ };
    const unsigned char iv[] = { /* your iv here */ };

    // Create a CBC mode encryptor
    CryptoPP::CBC_Mode<CryptoPP::AES>::Encryption encryptor(key, sizeof(key), iv);

    // Create a string sink
    std::string ciphertext;
    CryptoPP::StringSink sink(ciphertext);

    // Set up the source
    CryptoPP::ArraySource(iv, sizeof(iv), true,
        new CryptoPP::Redirector(sink)
    );

    // Encrypt
    encryptor.ProcessData(sink);

    return 0;
}