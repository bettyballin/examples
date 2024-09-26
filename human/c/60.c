#include <openssl/x509.h>
#include <openssl/x509_vfy.h>

static int verificationCallback(int ok, X509_STORE_CTX *ctx) {
    switch (ctx->error)
    {
        case X509_V_ERR_CERT_HAS_EXPIRED: 
            X509_STORE_CTX_set_error(ctx, X509_V_OK);
            ok = 1;
            break;
    }
    return ok;
}

int main() {
    return 0;
}