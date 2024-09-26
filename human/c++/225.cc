cpp
#include <cryptopp/osrng.h>
#include <cryptopp/ecdh.h>
#include <cryptopp/secblock.h>

using namespace CryptoPP;

int main() {
    ECDH<ECP>::Domain dhB(CURVE);
    SecByteBlock privB(dhB.PrivateKeyLength()), pubB(dhB.PublicKeyLength());
    AutoSeededRandomPool rng;
    dhB.GenerateKeyPair(rng, privB, pubB);
    return 0;
}