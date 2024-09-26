cpp
#include <botan/botan.h>
#include <botan/hex.h>
#include <iostream>

int main() {
    std::string encordedText = "your_encoded_text_here";
    Botan::LibraryInitializer init;
    Botan::secure_vector<uint8_t> tmpPlainText(Botan::hex_decode_locked(encordedText));
    return 0;
}