#include <stdint.h>

uint32_t htonl(uint32_t host) {
    return ((host & 0x000000FF) << 24) |
           ((host & 0x0000FF00) <<  8) |
           ((host & 0x00FF0000) >>  8) |
           ((host & 0xFF000000) >> 24);
}

uint32_t ntohl(uint32_t netlong) {
    return htonl(netlong);
}

int main() {
    uint32_t host = 0x12345678;
    uint32_t netlong = htonl(host);
    uint32_t result = ntohl(netlong);
    return 0;
}