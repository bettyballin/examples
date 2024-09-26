cpp
#include <iostream>

void applyXTEATransformation(uint8_t* plainText, uint8_t* cipherText, uint8_t* key) {
    uint32_t* plainText32 = (uint32_t*)plainText;
    uint32_t* cipherText32 = (uint32_t*)cipherText;
    uint32_t* key32 = (uint32_t*)key;

    cipherText32[0] = plainText32[0] ^ key32[0];
    cipherText32[1] = plainText32[1] ^ key32[1];
}

int main() {
    uint8_t plainText[8];
    plainText[0] = 16;
    plainText[1] = 17;
    plainText[2] = 18;
    plainText[3] = 19;
    plainText[4] = 20;
    plainText[5] = 21;
    plainText[6] = 22;
    plainText[7] = 23;

    uint8_t keyOfLength128Bit[16];
    for (int i = 0; i < 16; i++) {
        keyOfLength128Bit[i] = i;
    }

    uint8_t cipherText[8];
    applyXTEATransformation(plainText, cipherText, keyOfLength128Bit);

    uint8_t dataToBeEncrypted[24];
    for (int i = 0; i < 24; i++) {
        dataToBeEncrypted[i] = i;
    }

    uint8_t transformedData[24];
    transformedData[16] = dataToBeEncrypted[16] ^ cipherText[0];
    transformedData[17] = dataToBeEncrypted[17] ^ cipherText[1];
    transformedData[18] = dataToBeEncrypted[18] ^ cipherText[2];
    transformedData[19] = dataToBeEncrypted[19] ^ cipherText[3];
    transformedData[20] = dataToBeEncrypted[20] ^ cipherText[4];
    transformedData[21] = dataToBeEncrypted[21] ^ cipherText[5];
    transformedData[22] = dataToBeEncrypted[22] ^ cipherText[6];
    transformedData[23] = dataToBeEncrypted[23] ^ cipherText[7];

    return 0;
}