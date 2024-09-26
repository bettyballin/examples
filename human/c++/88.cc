cpp
#include <iostream>
#include <iomanip>

template<class Iter>
void print_hex(Iter beg, Iter end)
{
    std::cout << std::hex << std::setfill('0');
    unsigned int x = 0;
    while (beg != end)
    {
        std::cout << std::setw(2) << static_cast<unsigned int>(*beg) << ' ';
        if (++beg != end && ++x % 16 == 0)
            std::cout << '\n';
    }
    std::cout << '\n';
}

int main() {
    unsigned char data[] = {0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F, 0x10, 0x11, 0x12};
    print_hex(data, data + sizeof(data));
    return 0;
}