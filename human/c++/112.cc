cpp
#include <iostream>
#include <cassert>

namespace CryptoPP {
    void memcpy_s(void* dest, size_t destSize, const void* src, size_t count) {
        assert(dest != nullptr);
        assert(src != nullptr);
        assert(count <= destSize);
        std::memcpy(dest, src, count);
    }
}

int main() {
    int src[] = {1, 2, 3, 4, 5};
    int dest[5];
    CryptoPP::memcpy_s(dest, sizeof(dest), src, sizeof(src));
    for (int i = 0; i < 5; i++) {
        std::cout << dest[i] << " ";
    }
    return 0;
}