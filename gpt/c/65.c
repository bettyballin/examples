
void encrypt() {
    unsigned char o[32];
    unsigned char key[16] = { /* ... */ };
    unsigned char iv[16] = { /* ... */ };
    unsigned char original_iv[16]; // To store the original IV
    memcpy(original_iv, iv, 16); // Copy the original
