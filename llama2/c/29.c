#include <openssl/hmac.h>
#include <iostream>
#include <iomanip>

using namespace std;

int main(void)
{
    // Key for HMAC
    unsigned char mac_key[16] = {0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};

    // Data to be authenticated
    unsigned char data[20] = {0x00};

    // Initialize HMAC context
    HMAC_CTX *ctx = HMAC_CTX_new();

    // Set key for HMAC
    HMAC_Init_ex(ctx, mac_key, 16, EVP_sha256(), NULL);

    // Set data to be authenticated
    HMAC_Update(ctx, data, 20);

    // Generate authentication tag
    unsigned char tag[32];
    unsigned int tag_len = 32;
    HMAC_Final(ctx, tag, &tag_len);

    // Print authentication tag
    cout << "Authentication Tag: ";
    for (int i = 0; i < tag_len; i++)
    {
        cout << hex << setw(2) << setfill('0') << (int)tag[i];
    }
    cout << endl;

    // Clean up
    HMAC_CTX_free(ctx);

    return 0;
}