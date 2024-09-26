cpp
#include <cryptopp/hex.h>
#include <cryptopp/filters.h>
#include <string>
#include <iostream>

int main() {
    std::string source = "48656c6c6f20576f726c64"; // Example source string
    std::string destination;

    CryptoPP::StringSource ss(source, true, new CryptoPP::HexDecoder(new CryptoPP::StringSink(destination)));

    const byte* result = (const byte*) destination.data();

    // Print the result
    for (size_t i = 0; i < destination.size(); ++i) {
        std::cout << static_cast<char>(result[i]);
    }

    return 0;
}