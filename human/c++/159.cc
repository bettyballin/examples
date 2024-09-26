cpp
#include <cryptopp/eccrypto.h>
#include <cryptopp/osrng.h>
#include <cryptopp/hex.h>
#include <iostream>

int main()
{
    using namespace CryptoPP;

    AutoSeededRandomPool rng;

    // Curve
    ECC::EllipticCurve ec;
    ec.AccessGroupParameters().Initialize(CurveID::SECP256R1);

    // Prime
    Integer prime(ec.GetField().GetModulus());
    std::cout << "Prime: " << std::hex << prime << "h" << std::endl;

    // Order
    Integer order(ec.GetOrder());
    std::cout << "Order: " << std::hex << order << "h" << std::endl;

    // Generator
    ECP ecg(ec);
    ecg = ec.GetBasePoint();
    std::cout << "Generator" << std::endl;
    std::cout << "  c1: " << std::hex << ecg.x << "h" << std::endl;
    std::cout << "  c2: " << std::hex << ecg.y << "h" << std::endl;

    return 0;
}