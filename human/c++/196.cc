cpp
#include <cryptopp/aes.h>
#include <cryptopp/osrng.h>

int main() {
    CryptoPP::AutoSeededRandomPool prng;
    unsigned char iv[CryptoPP::AES::BLOCKSIZE];
    prng.GenerateBlock(iv, sizeof(iv));
    return 0;
}