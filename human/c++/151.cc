cpp
#include <iostream>

int main() {
    unsigned char image[8];
    unsigned char textArray[] = {0x12}; // example value
    unsigned char mask = 0xFE; // example mask
    int pixCount = 0;
    int i = 0;

    for (int j = 7; j >= 0; j--) {
        image[pixCount] = (image[pixCount] & mask) | ((textArray[i] >> j) & 0x01);
        pixCount++;
    }

    // print the result
    for (int k = 0; k < 8; k++) {
        std::cout << (int)image[k] << " ";
    }
    std::cout << std::endl;

    return 0;
}