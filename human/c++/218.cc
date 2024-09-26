cpp
#include <iostream>
#include <sstream>
#include <cstdint>

int main() {
    std::uint64_t x;
    std::stringstream ss;

    ss << std::hex << "0x3C29786A4F7E78255E9A965456A6D989A4EC37BC4477A934C52F39ECFD573344";
    ss >> x;

    std::cout << "Result 1: " << static_cast<std::int64_t>(x) << std::endl;

    ss.clear();
    ss << std::hex << "0x3C29786A4F7E78255E9A965456A6D989A4EC37BC4477A934C52F39ECFD573344";
    ss >> x;

    return 0;
}