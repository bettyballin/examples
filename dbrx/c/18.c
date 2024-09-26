#include <openssl/sha.h>
#include <string>
#include <iostream>

int main() {
    std::string input = "Hello, World!";
    unsigned char digest[SHA_DIGEST_LENGTH];
    SHA1((const unsigned char*)input.c_str(), input.length(), digest);

    // print the digest
    for (int i = 0; i < SHA_DIGEST_LENGTH; i++) {
        printf("%02x", digest[i]);
    }
    printf("\n");

    return 0;
}