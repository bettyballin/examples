You provided a Git command, not C++ code. However, I assume you want me to provide the C++ code for the Keccak hash function from the repository you mentioned. Here is an executable C++ code:

cpp
#include <iostream>
#include <string>

// Keccak-f round constants
unsigned long long KeccakF_RoundConstants[24] = {
    0x0000000000000001, 0x0000000000008082, 0x800000000000808a,
    0x8000000080008000, 0x000000000000808b, 0x0000000080000001,
    0x8000000080008081, 0x8000000000008009, 0x000000000000008a,
    0x0000000000000088, 0x0000000080008009, 0x000000008000000a,
    0x000000008000808b, 0x800000000000008b, 0x8000000000008089,
    0x8000000080008003, 0x8000000080008002, 0x8000000080000080,
    0x000000000000800a, 0x800000008000000a, 0x8000000080008081,
    0x8000000000008080, 0x0000000080000001, 0x8000000080008008,
};

void KeccakF(unsigned long long *s) {
    unsigned long long t[5], bc[5];
    int r, i;

    for (r = 0; r < 24; r++) {
        // theta
        for (i = 0; i < 5; i++)
            bc[i] = s[i] ^ s[(i + 4) % 5] ^ s[(i + 3) % 5];

        for (i = 0; i < 5; i++) {
            t[i] = bc[(i + 4) % 5] ^ ((bc[(i + 1) % 5] << 1) | (bc[(i + 1) % 5] >> 63));
        }

        for (i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                s[i * 5 + j] ^= t[i];

        // rho & pi
        t[1] = s[6];
        t[2] = s[2];
        t[3] = s[12];
        t[4] = s[1];

        for (i = 0; i < 5; i++) {
            s[i * 5 + 1] = t[i] << (i * 2 + 1);
            s[i * 5 + 2] = (s[i * 5 + 2] >> (i * 2 + 3)) | (s[i * 5 + 2] << (64 - (i * 2 + 3)));
            s[i * 5 + 3] = (s[i * 5 + 3] >> (i * 2 + 6)) | (s[i * 5 + 3] << (64 - (i * 2 + 6)));
            s[i * 5 + 4] = (s[i * 5 + 4] >> (i * 2 + 10)) | (s[i * 5 + 4] << (64 - (i * 2 + 10)));
        }

        // chi
        for (i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                t[j] = s[i * 5 + j];
            }

            for (int j = 0; j < 5; j++)
                s[i * 5 + j] = t[j] ^ ((~t[(j + 1) % 5]) & t[(j + 2) % 5]);
        }

        // iota
        s[0] ^= KeccakF_RoundConstants[r];
    }
}

void Keccak(unsigned long long *result, unsigned char *input, int inputByteLen, int outputByteLen) {
    unsigned long long s[25];
    int i, j;

    // Initialize
    for (i = 0; i < 25; i++)
        s[i] = 0;

    // Absorb
    for (i = 0; i < inputByteLen; i += 8) {
        unsigned long long t = 0;
        for (j = 0; j < 8; j++) {
            if (i + j < inputByteLen)
                t |= (unsigned long long)input[i + j] << (8 * j);
        }

        s[i / 8] ^= t;
    }

    s[inputByteLen / 8] ^= 0x8000000000000000;

    // Squeeze
    KeccakF(s);

    // Extract
    for (i = 0; i < outputByteLen; i += 8) {
        result[i / 8] = s[i / 8];
    }
}

int main() {
    std::string message = "Hello, Keccak!";
    unsigned char input[message.length()];
    for (int i = 0; i < message.length(); i++)
        input[i] = message[i];

    unsigned long long result[32];
    Keccak(result, input, message.length(), 32 * 8);

    std::cout << "Keccak-256: ";
    for (int i = 0; i < 32; i++) {
        std::cout << std::hex << (result[i] & 0xFF);
    }
    std::cout << std::endl;

    return 0;
}