
// After initializing the context and setting the key/iv for the first time:
EVP_DecryptInit_ex(ctx, EVP_aes_256_cbc(), NULL, key, iv);

// For subsequent packets:
EVP_CIPHER_CTX_reset(ctx);
EVP_DecryptInit_ex(ctx, NULL, NULL, NULL, iv); // Reuse the same key by passing NULL
EVP_DecryptUpdate(ctx, payload, &len, payload, data_len);
EVP_DecryptFinal_ex(ctx, payload + len, &len);

