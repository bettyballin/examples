#include <openssl/x509.h>

static int verificationCallback(int ok, X509_STORE_CTX *ctx) {
    switch (ctx->error)
    {
        case X509_V_ERR_INVALID_PURPOSE:
        case X509_V_ERR_CERT_HAS_EXPIRED:
        case X509_V_ERR_KEYUSAGE_NO_CERTSIGN:
        case X509_V_ERR_DEPTH_ZERO_SELF_SIGNED_CERT:
            // todo: handle the error
            ok = 0;
            break;
        default:
            break;
    }
    return ok;
}

int main() {
    // todo: initialize OpenSSL
    X509_STORE_CTX *ctx;
    // todo: create and initialize ctx
    int ok = verificationCallback(1, ctx);
    return 0;
}