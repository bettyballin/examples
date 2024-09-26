cpp
#include <cryptopp/eccrypto.h>
#include <cryptopp/osrng.h>
#include <cryptopp/integer.h>
#include <iostream>
#include <iomanip>

int main(int argc, char* argv[]) {
    using namespace CryptoPP;

    AutoSeededRandomPool prng;
    ECC::PrimeCurve p256;
    p256.AccessGroupParameters().Initialize(prng, ASN1::secp256r1());

    const Integer& prime = p256.GetField().GetModulus();
    const Integer& order = p256.GetOrder();
    const Integer& c1 = p256.GetBasePoint().x;
    const Integer& c2 = p256.GetBasePoint().y;

    std::cout << "Prime: " << std::hex << prime << std::endl;
    std::cout << "Order: " << std::hex << order << std::endl;
    std::cout << "Generator" << std::endl;
    std::cout << "  c1: " << std::hex << c1 << std::endl;
    std::cout << "  c2: " << std::hex << c2 << std::endl;

    return 0;
}