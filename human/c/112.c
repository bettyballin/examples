#include <openssl/evp.h>
#include <openssl/cmac.h>

#include <stdio.h>
#include <string.h>
#include <assert.h>

void dispHex(const unsigned char *buffer, unsigned int size) {
    unsigned int i=0;

    for (i=0; i<size; i++) {
        printf("%02X ", buffer[i]);
    }
    printf("\n");
}

int main() {
    int rc = 0;
    size_t out_len = 0;
    unsigned char res[EVP_MAX_MD_SIZE];

    unsigned char mac_key[16] = { 0x00, 0x01 ,0x02 ,0x03, 0x04, 0x05, 0x06, 0x07,
                            0x00, 0x01 ,0x02 ,0x03, 0x04, 0x05, 0x06, 0x07};

    unsigned char msg[16] = { 0x00, 0x01 ,0x02 ,0x03, 0x04, 0x05, 0x06, 0x07,
                            0x00, 0x01 ,0x02 ,0x03, 0x04, 0x05, 0x06, 0x07};

    CMAC_CTX *cmac = CMAC_CTX_new();
    assert(cmac != NULL);

    rc = CMAC_Init(cmac, mac_key, sizeof(mac_key), EVP_aes_128_cbc(), NULL);
    assert(rc == 1);

    rc = CMAC_Update(cmac, msg, sizeof(msg));
    assert(rc == 1);

    rc = CMAC_Final(cmac, res, &out_len);
    assert(rc == 1);

    dispHex(res, out_len);

    CMAC_CTX_free(cmac);

    return 0;
}


Compile with: 
bash
gcc code.c -o code -lcrypto


Run with: 
bash
./code