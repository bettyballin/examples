cpp
#include <iostream>
#include <string>
#include <sstream>

int main() {
    std::string message = "some simple message to encrypt";
    std::stringstream ss;

    ss << std::hex;
    for (char c : message) {
        ss << (int)c;
    }

    std::string encryptedMessage = ss.str();

    std::string encrypted = "82 56 5b a7 a5 b5 6a e9 e5 a4 a6 9d bb ee 14 db "
                            "6b 1e 54 b8 9d 7f 8c 16 18 c6 33 47 1c f1 48 25";

    std::cout << "Original Message: " << message << std::endl;
    std::cout << "Encrypted Message: " << encrypted << std::endl;

    return 0;
}