cpp
#include <cryptopp/rsa.h>
#include <cryptopp/osrng.h>

int main() {
    CryptoPP::AutoSeededRandomPool prng;
    CryptoPP::RSA::KeyPair params;
    params.GenerateRandomWithKeySize(prng, 2048);
    params.SetPublicExponent(65537);
    return 0;
}