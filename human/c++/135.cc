cpp
#include <iostream>

unsigned long power(unsigned long basis, unsigned long exponent) {
    unsigned long result = 1u;
    unsigned long factor = basis;
    unsigned long i;

    for (i = 1u; i < exponent; i = i * 2u) {
        /* i is some power of two,
           and factor = basis**i.
        */

        /* If i is in the sum (of powers of two) for exponent,
           we include the corresponding power of basis
           in the product. */
        if (i & exponent)
            result = result * factor;

        /* Update factor for the next i. */
        factor = factor * factor;
    }

    return result;
}

int main() {
    unsigned long basis, exponent;
    std::cout << "Enter the basis: ";
    std::cin >> basis;
    std::cout << "Enter the exponent: ";
    std::cin >> exponent;

    unsigned long result = power(basis, exponent);
    std::cout << basis << " to the power of " << exponent << " is: " << result << std::endl;

    return 0;
}