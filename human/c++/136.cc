cpp
#include <iostream>

unsigned long power(unsigned long basis, unsigned long exponent) {
    unsigned long result = 1u;

    while (exponent > 0u) {
        if (exponent & 1u)
            result = result * basis;
        basis = basis * basis;
        exponent = exponent >> 1;
    }

    return result;
}

int main() {
    unsigned long basis = 2;
    unsigned long exponent = 3;
    std::cout << "Result: " << power(basis, exponent) << std::endl;
    return 0;
}