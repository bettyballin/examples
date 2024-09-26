cpp
#include <cstdint>
#include <iostream>

int main() {
    uint64_t a = 0x1234567812345678;
    uint64_t b = 0x8765432187654321;
    uint32_t mask = (uint32_t)(( (uint64_t)a - (uint64_t)b ) >> 32);
    std::cout << std::hex << mask << std::endl;
    return 0;
}