cpp
#include <cryptopp/rsa.h>
#include <cryptopp/osrng.h>

int main() {
    using namespace CryptoPP;

    AutoSeededRandomPool prng;
    RSA::PrivateKey params;

    params.SetPublicExponent(65537);
    params.GenerateRandomWithKeySize(prng, 2048);

    return 0;
}