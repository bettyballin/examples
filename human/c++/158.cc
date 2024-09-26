cpp
#include "cryptlib.h"
#include "osrng.h"
#include "files.h"
#include "xtrcrypt.h"

#include <iostream>

int main()
{
    using namespace CryptoPP;

    AutoSeededRandomPool prng;
    XTR_DH xtrA(prng, 170, 160);
    xtrA.DEREncode(FileSink("params.der").Ref());
    XTR_DH xtrB(FileSource("params.der", true).Ref());

    std::cout << "Prime: " << std::hex << xtrB.GetModulus() << std::endl;
    std::cout << "Order: " << std::hex << xtrB.GetSubgroupOrder() << std::endl;
    std::cout << "Generator" << std::endl;
    std::cout << "  c1: " << std::hex << xtrB.GetSubgroupGenerator().c1 << std::endl;
    std::cout << "  c2: " << std::hex << xtrB.GetSubgroupGenerator().c2 << std::endl;

    return 0;
}