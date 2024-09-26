cpp
#include <iostream>
#include <string>
#include <cstdint>
#include "modes.h"
#include "filters.h"
#include "des.h"

bool ValidateCipherModes()
{
    byte key[] = {1,2,3,4,5,6,7,8};
    byte iv[] = {1,2,3,4,5,6,7,8};

    DESEncryption desE(key);
    DESDecryption desD(key);

    CBC_Mode_ExternalCipher::Encryption modeE(desE, iv);
    CBC_Mode_ExternalCipher::Decryption modeD(desD, iv);

    std::string plainText = "Hello, World!";
    std::string cipherText;

    StringSource(plainText, true, new StreamTransformationFilter(modeE, new StringSink(cipherText)));

    std::string decryptedText;
    StringSource(cipherText, true, new StreamTransformationFilter(modeD, new StringSink(decryptedText)));

    return plainText == decryptedText;
}

int main()
{
    std::cout << std::boolalpha << ValidateCipherModes() << std::endl;
    return 0;
}