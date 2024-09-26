cpp
#include <cstdint>
#include <iostream>

int main() {
    uint32_t a = 5, b = 3;
    uint32_t mask = -((a - b) >> 31);
    a = ((a + b) & mask) | (a & ~mask);
    std::cout << "Result: " << a << std::endl;
    return 0;
}