cpp
#include <cryptopp/cryptlib.h>
#include <cryptopp/osrng.h>
#include <cryptopp/files.h>
#include <cryptopp/xtrdh.h>
#include <stdexcept>

int main()
{
    using namespace CryptoPP;

    AutoSeededRandomPool prng;
    XTR_DH xtrA(FileSource("params.der", true).Ref());
    XTR_DH xtrB(FileSource("params.der", true).Ref());

    if(xtrA.Validate(prng, 3) == false)
        throw std::runtime_error("Failed to validate parameters");

    if(xtrB.Validate(prng, 3) == false)
        throw std::runtime_error("Failed to validate parameters");

    return 0;
}