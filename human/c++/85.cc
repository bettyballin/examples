cpp
#include <iostream>
#include <openssl/aes.h>

int main() {
    unsigned char iBuffer[10] = {0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09};
    unsigned char oBuffer[10];
    int olen = 0;

    AES_KEY cipher_ctx;
    AES_set_encrypt_key((const unsigned char *)"0123456789abcdef", 128, &cipher_ctx);
    AES_encrypt(iBuffer, oBuffer, &cipher_ctx);

    std::cout << "Encrypted: ";
    for (int i = 0; i < 10; i++) {
        std::cout << std::hex << (int)oBuffer[i];
    }
    std::cout << std::endl;

    return 0;
}