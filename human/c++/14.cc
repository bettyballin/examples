cpp
#include <iostream>

int main() {
    int array[0x200/4]; // assuming 4-byte integers
    int* argv1 = &array[0];
    int* arrayPtr = &array[0];

    // equivalent to mov DWORD PTR [esp+0x4], eax
    *(argv1 + 1) = 0; // replace 0 with desired value

    // equivalent to mov DWORD PTR [esp], eax
    *arrayPtr = 0; // replace 0 with desired value

    return 0;
}