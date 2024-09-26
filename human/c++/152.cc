cpp
#include <iostream>

int main() {
    unsigned char character = 0b11010111; // example value 'abcdefgh'

    for (int j = 7; j >= 0; --j) {
        std::cout << "j = " << j << std::endl;
        std::cout << "(character >> j) & 0x01 = " << ((character >> j) & 0x01) << std::endl;
    }

    return 0;
}