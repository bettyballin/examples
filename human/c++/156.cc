cpp
#include "cryptlib.h"
#include "osrng.h"
#include "xtrcrypt.h"

#include <iostream>

int main()
{
    using namespace CryptoPP;

    AutoSeededRandomPool aSRP;
    XTR_DH xtrA(aSRP, 170, 160);

    const Integer& iPrime = xtrA.GetModulus();
    const Integer& iOrder = xtrA.GetSubgroupOrder();
    const GFP2Element& iGenerator = xtrA.GetSubgroupGenerator();

    XTR_DH xtrB(iPrime, iOrder, iGenerator);

    std::cout << "Prime: " << std::hex << xtrB.GetModulus() << std::endl;
    std::cout << "Order: " << std::hex << xtrB.GetSubgroupOrder() << std::endl;
    std::cout << "Generator" << std::endl;
    std::cout << "  c1: " << std::hex << xtrB.GetSubgroupGenerator().c1 << std::endl;
    std::cout << "  c2: " << std::hex << xtrB.GetSubgroupGenerator().c2 << std::endl;

    return 0;
}