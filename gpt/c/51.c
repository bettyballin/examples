
#include <stdio.h>
#include <string.h>
#include <openssl/aes.h>
#include <openssl/rand.h>

typedef struct ticket {
    int ticketId;
    char username[20];
    char date[20];
} USR_TICKET;

void print_hex(const void* pv, size_t len) {
    const unsigned char * p = (const unsigned char*)pv;
    for (size_t i = 0; i < len; ++i) {
        printf("%02X ", p[i]);
    }
    printf("\n");
}

int main() {
    // Initialize AES key
