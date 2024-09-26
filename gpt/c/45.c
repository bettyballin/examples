
#include <stdint.h>
#include <stddef.h>

#define ROTL(a,b) (((a) << (b)) | ((a) >> (32 - (b))))
#define QR(a, b, c, d) (            \
    a += b, d ^= a, d = ROTL(d,16), \
    c += d, b ^= c, b = ROTL(b,12), \
    a += b, d ^= a, d = ROTL(d, 8), \
    c += d, b ^= c, b = ROTL(b,7)   \
)

static uint32_t state[16];

void chacha20_init(uint32_t seed[8]) {
    // Constants defined in the ChaCha20 specification (RFC 8439)
    static const uint32_t constants[4] = {
        0x617078
