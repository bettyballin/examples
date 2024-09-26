#include <stdio.h>
#include <ecc.h>

int main() {
    unsigned char p_privateKey[32];
    unsigned char p_publicKey[33];
    ecc_key l_private, l_public;

    // Initialize keys
    ecc_make_key(&l_private, &l_public);

    ecc_native2bytes(p_privateKey, l_private);
    ecc_native2bytes(p_publicKey + 1, l_public.x);
    p_publicKey[0] = 2 + (l_public.y[0] & 0x01);

    return 0;
}