cpp
// adler32.cpp

#include <botan/adler32.h>

namespace Botan {

size_t adler32_checksum(const uint8_t input[], size_t length,
                        uint32_t initial_adler, uint32_t& out_adler) {
    uint32_t A = initial_adler & 0xFFFF;
    uint32_t B = initial_adler >> 16;

    for (size_t i = 0; i != length; ++i) {
        A = (A + input[i]) % 65521;
        B = (B + A) % 65521;
    }

    out_adler = (B << 16) | A;
    return 4; // size of checksum
}

}