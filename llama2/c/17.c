#include <stdio.h>
#include <string.h>
#include <openssl/des.h>

typedef struct {
    DES_key_schedule ks1;
    DES_key_schedule ks2;
    DES_key_schedule ks3;
} triple_des_key;

triple_des_key generate_triple_des_key(const char *password) {
    triple_des_key key;
    DES_key_schedule ks1, ks2, ks3;
    unsigned char key1[8], key2[8], key3[8];

    // Generate three 8-byte keys from the password
    for (int i = 0; i < 8; i++) {
        key1[i] = password[i];
        key2[i] = password[i+8];
        key3[i] = password[i+16];
    }

    // Set the three keys
    DES_set_key((const_DES_cblock *)key1, &ks1);
    DES_set_key((const_DES_cblock *)key2, &ks2);
    DES_set_key((const_DES_cblock *)key3, &ks3);

    // Store the keys in the triple_des_key struct
    key.ks1 = ks1;
    key.ks2 = ks2;
    key.ks3 = ks3;

    return key;
}

void triple_des_encrypt(const triple_des_key *key, const unsigned char *plaintext, unsigned char *ciphertext) {
    int len = strlen((const char *)plaintext);
    unsigned char *p = (unsigned char *)plaintext;
    unsigned char *c = ciphertext;

    // Pad the plaintext to a multiple of 8 bytes
    while (len % 8 != 0) {
        *p++ = '\0';
        len++;
    }

    // Encrypt the plaintext
    for (int i = 0; i < len; i += 8) {
        DES_ede3_cbc_encrypt(p, c, 8, &key->ks1, &key->ks2, &key->ks3, (const_DES_cblock *)"01234567", DES_ENCRYPT);
        p += 8;
        c += 8;
    }
}

void triple_des_decrypt(const triple_des_key *key, const unsigned char *ciphertext, unsigned char *plaintext) {
    int len = strlen((const char *)ciphertext);
    unsigned char *c = (unsigned char *)ciphertext;
    unsigned char *p = plaintext;

    // Decrypt the ciphertext
    for (int i = 0; i < len; i += 8) {
        DES_ede3_cbc_encrypt(c, p, 8, &key->ks1, &key->ks2, &key->ks3, (const_DES_cblock *)"01234567", DES_DECRYPT);
        c += 8;
        p += 8;
    }
}

int main() {
    const char *password = "password1234567890123456";
    triple_des_key key = generate_triple_des_key(password);

    const unsigned char *plaintext = (const unsigned char *)"Hello, World!";
    unsigned char ciphertext[256];
    triple_des_encrypt(&key, plaintext, ciphertext);

    printf("Ciphertext: %s\n", ciphertext);

    unsigned char decrypted[256];
    triple_des_decrypt(&key, ciphertext, decrypted);

    printf("Decrypted: %s\n", decrypted);

    return 0;
}