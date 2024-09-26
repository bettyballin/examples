cpp
#include <cryptopp/rsa.h>
#include <cryptopp/osrng.h>

int main() {
    CryptoPP::AutoSeededRandomPool rng;

    CryptoPP::InvertibleRSAFunction params;
    params.GenerateRandomWithKeySize(rng, 2048);

    return 0;
}