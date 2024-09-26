cpp
#include <iostream>
#include <Security/Security.h>
#include <vector>

int main(int argc, const char * argv[]) {
    const int length = 20;
    std::vector<uint8_t> randomBytes(length, 0);

    int rc = SecRandomCopyBytes(kSecRandomDefault, randomBytes.size(), &(randomBytes[0]));
    if (rc != 0) {
        std::cout << "Failed: " << rc << std::endl;
        return 1;
    }

    for (int i = 0; i < randomBytes.size(); ++i) {
        std::cout << std::hex << static_cast<int>(randomBytes[i]) << " ";
    }
    std::cout << std::endl;

    return 0;
}