cpp
#include <iostream>

int main() {
    unsigned char image[10] = {0};  // assuming image array
    unsigned char textArray[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // assuming textArray
    int pixCount = 0;
    int i = 0;

    unsigned char mask = 0xfe;  // in binary 11111110

    // and in your loop
    for (; pixCount < 10; pixCount++, i++) {
        image[pixCount] = (image[pixCount] & mask) | (textArray[i] & 1);
    }

    // print the modified image array
    for (int i = 0; i < 10; i++) {
        std::cout << (int)image[i] << " ";
    }

    return 0;
}