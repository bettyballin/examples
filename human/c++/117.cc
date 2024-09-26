cpp
#include <openssl/pkcs12.h>
#include <Foundation/Foundation.h>

int main() {
    PKCS12 *p12 = NULL; // initialize p12 with your PKCS12 object

    BIO *bio = BIO_new(BIO_s_mem());
    assert(bio != NULL);

    int ret = i2d_PKCS12_bio(bio, p12);
    assert(ret == 1);

    BUF_MEM *buffer;
    BIO_get_mem_ptr(bio, &buffer);
    assert(buffer != NULL);

    NSData *data = [NSData dataWithBytes:buffer->data length:buffer->length];
    BIO_free_all(bio);

    return 0;
}