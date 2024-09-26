cpp
#include <iostream>

int main() {
    uint a = 5, b = 10;
    uint mask = -(uint)(a < b);
    a = ((a + b) & mask) | (a & ~mask);
    std::cout << a << std::endl;
    return 0;
}