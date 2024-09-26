cpp
#include <string>
#include <cryptopp/secblock.h>

using secure_string = std::basic_string<char, std::char_traits<char>, CryptoPP::AllocatorWithCleanup<char>>;

int main() {
    secure_string str("Hello, World!");
    return 0;
}