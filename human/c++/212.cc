cpp
#include "cryptopp/nbtheory.h"
#include <iostream>

using namespace CryptoPP;

Integer getSquareRoot(Integer &y, Integer &mod) {
    if (Jacobi(y, mod) != 1)
        return -1;

    return y = ModularSquareRoot(y, mod);
}

int main() {
    // assuming 'sr', 'ecmod', 'ma', and 'xb' are defined somewhere
    Integer ecmod = 23; // define ecmod
    Integer sr = 4; // define sr
    Integer xb = 3; // define xb
    ModularArithmetic ma(ecmod);

    sr = ma.Add(sr, xb);

    Integer y = getSquareRoot(sr, ecmod);
    if (y != -1) {
        std::cout << IntToString<Integer>(y) << std::endl;
    } else {
        std::cout << IntToString<Integer>(sr);
        std::cout << " has not square root to " << ecmod << std::endl;
    }
    return 0;
}