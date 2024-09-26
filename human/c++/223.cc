cpp
#include <iostream>
#include <cstdint>

uint64_t encrypt(uint64_t plaintext, uint64_t key, uint64_t rule) {
    uint64_t ciphertext = plaintext;
    for (int i = 0; i < 32; i++) {
        uint64_t roundKey = (key << (4 * i)) >> 60;
        uint64_t roundT = ((ciphertext >> 60) ^ roundKey) & 0xF;
        uint64_t sboxOut = (rule >> (4 * roundT)) & 0xF;
        ciphertext = (ciphertext << 4) | sboxOut;
    }
    return ciphertext;
}

uint64_t decrypt(uint64_t ciphertext, uint64_t key, uint64_t rule) {
    uint64_t plaintext = ciphertext;
    for (int i = 0; i < 32; i++) {
        uint64_t roundKey = (key << (4 * (31 - i))) >> 60;
        uint64_t roundT = (plaintext & 0xF) ^ roundKey;
        uint64_t sboxInv = 0;
        for (int j = 0; j < 16; j++) {
            if (((rule >> (4 * j)) & 0xF) == roundT) {
                sboxInv = j;
                break;
            }
        }
        plaintext = (plaintext >> 4) | ((sboxInv ^ roundKey) << 60);
    }
    return plaintext;
}

int main() {
    uint64_t p = 0xdeadbeefcafebabe;
    uint64_t k = 0xf6c78663f3578746;
    uint64_t rules[] = {0x29, 0x51, 0x204, 0x205};
    uint64_t e[] = {0xce09bfd34be8a898, 0xce09bfd34be8a898, 0xce09bfd34be8a898, 0xce09bfd34be8a898};
    uint64_t d[] = {0xdeadbeefcafebabe, 0xdeadbeefcafebabe, 0xdeadbeefcafebabe, 0xdeadbeefcafebabe};

    for (int i = 0; i < 4; i++) {
        uint64_t c = encrypt(p, k, rules[i]);
        std::cout << "RULE " << rules[i] << std::endl;
        std::cout << "P: " << std::hex << p << std::endl;
        std::cout << "K: " << std::hex << k << std::endl;
        std::cout << "E: " << std::hex << c << std::endl;
        uint64_t dec = decrypt(c, k, rules[i]);
        std::cout << "D: " << std::hex << dec << std::endl << std::endl;
    }

    return 0;
}