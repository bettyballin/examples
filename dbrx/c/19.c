#include <cryptopp/sha.h>
#include <string>
#include <iostream>

int main() {
    std::string input;
    std::cout << "Enter a string: ";
    std::getline(std::cin, input);

    CryptoPP::SHA1 sha;
    byte digest[CryptoPP::SHA1::DIGESTSIZE];
    sha.CalculateDigest(digest, (const byte*)input.c_str(), input.length());

    std::cout << "SHA-1 digest: ";
    for (int i = 0; i < CryptoPP::SHA1::DIGESTSIZE; i++) {
        std::cout << std::hex << (int)digest[i];
    }
    std::cout << std::endl;

    return 0;
}