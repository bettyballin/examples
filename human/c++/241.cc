cpp
#include <cstdint>
#include <iostream>
#include <iomanip>

#define func auto

union x128
{
    uint8_t     c[16];
    __uint128_t i;
};

std::ostream& operator << (std::ostream& os, x128 number) {
    os << "0x";
    for(auto k: number.c) {
        os << std::hex << std::setfill('0') << std::setw(2) << uint16_t(k);
    }
    return os;
}

std::ostream& operator << (std::ostream& os, __uint128_t number) {
    os << x128{.i=number};
    return os;
}

const __uint128_t m = x128{0xdb,0x36,0x35,0x77,0x34,0xe3,0x4a,0xbb,0x00,0x50,0xd0,0x76,0x1f,0xcd,0xfc,0x15}.i; 
const __uint128_t c = x128{0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x01}.i;

inline func lcg(__uint128_t xi) -> __uint128_t { 
    return m*xi + c;
}

const char NL = '\n';

func main() -> int {

    std::cout << c << NL;
    std::cout << m << NL;
    
    std::cout << lcg(0x18290177731772ULL) << NL;

    return 0;
}