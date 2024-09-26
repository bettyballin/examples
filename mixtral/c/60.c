#include <arpa/inet.h>
#include <endian.h>

// Convert from host byte order to network (big-endian)
uint32_t htonl(uint32_t hostlong) {
    return htobe32(hostlong);
}

// Convert from network (big-endian) byte order to host
uint32_t ntohl(uint32_t netlong) {
    return be32toh(netlong);
}

int main() {
    uint32_t hostlong = 0x12345678;
    uint32_t netlong = htonl(hostlong);
    printf("Host byte order: 0x%x\n", hostlong);
    printf("Network byte order: 0x%x\n", netlong);
    printf("Converted back to host byte order: 0x%x\n", ntohl(netlong));
    return 0;
}