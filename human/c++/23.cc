cpp
#include <iostream>
#include <iomanip>

int main() {
    unsigned char digest[] = "Hello, World!";
    for(int i=0;i<sizeof(digest);i++)
        std::cout << std::setfill('0') << std::setw(2) << std::hex << (int)digest[i];
    return 0;
}