
bool my_dsa_sign(const Certificate& certificate, const char* messageData, size_t messageLength, Signature &outSignature) {
    bool resultOk = false;
    BIO* bio = BIO_new_mem_buf((void*)certificate.getPEMData(), certificate.getSize());
    if (bio != NULL) {
        EVP_PKEY *pkey = PEM_read_bio_PrivateKey(bio, NULL, NULL, NULL);
        if (pkey != NULL) {
            EVP_MD_CTX *ctx = EVP_MD_CTX_new();
            if (ctx != NULL) {
                if (EVP_SignInit(ctx, EVP_sha512())) {
                    if (EVP_SignUpdate(ctx, messageData,
