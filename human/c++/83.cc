cpp
#include <iostream>
#include <cmath>

int main() {
    const double phi = (1 + std::sqrt(5)) / 2;
    const double the_constant = std::pow(2, 160) / phi;
    std::printf("0x%016llX %016llX\n", 
                static_cast<unsigned long long>(the_constant / std::pow(2, 64)), 
                static_cast<unsigned long long>(std::fmod(the_constant, std::pow(2, 64))));
    return 0;
}