cpp
#include <iostream>
#include <cstdint>

using namespace std;

class ZZ {
public:
    uint64_t value;
};

void ZZFromBytes(ZZ& x, const unsigned char* p, long n) {
    x.value = 0;
    for (int i = 0; i < n; i++) {
        x.value += static_cast<uint64_t>(p[i]) << (8 * i);
    }
}

ZZ ZZFromBytes(const unsigned char* p, long n) {
    ZZ x;
    ZZFromBytes(x, p, n);
    return x;
}

void BytesFromZZ(unsigned char* p, const ZZ& a, long n) {
    uint64_t value = a.value;
    for (int i = 0; i < n; i++) {
        p[i] = static_cast<unsigned char>(value & 0xFF);
        value >>= 8;
    }
}

long NumBytes(const ZZ& a) {
    uint64_t value = a.value;
    long count = 0;
    while (value > 0) {
        value >>= 8;
        count++;
    }
    return count;
}

long NumBytes(long a) {
    return NumBytes(ZZ{static_cast<uint64_t>(a)});
}

int main() {
    // Test the functions
    ZZ x;
    unsigned char p[] = {0x01, 0x02, 0x03, 0x04};
    ZZFromBytes(x, p, 4);
    cout << "ZZFromBytes: " << x.value << endl;

    unsigned char q[4];
    BytesFromZZ(q, x, 4);
    cout << "BytesFromZZ: ";
    for (int i = 0; i < 4; i++) {
        cout << static_cast<int>(q[i]) << " ";
    }
    cout << endl;

    cout << "NumBytes(ZZ): " << NumBytes(x) << endl;
    cout << "NumBytes(long): " << NumBytes(0x01020304L) << endl;

    return 0;
}