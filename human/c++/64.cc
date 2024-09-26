cpp
#include <iostream>
#include <fstream>
#include <iomanip>
#include <openssl/asn1.h>
#include <openssl/rsa.h>

int main() {
    FILE* file = fopen("key.der", "rb");
    if (!file) {
        std::cerr << "Failed to open file" << std::endl;
        return 1;
    }

    unsigned char buffer[4096];
    size_t len = fread(buffer, 1, 4096, file);
    fclose(file);

    const unsigned char* data = buffer;
    ASN1_const_CTX ctx;
    int ret = ASN1_get_object(&data, &len, &ctx, 0, 0, NULL, NULL, NULL);
    if (ret & 0x80) {
        std::cerr << "Failed to parse ASN.1 data" << std::endl;
        return 1;
    }

    ASN1_SEQUENCE_ANY* seq = d2i_ASN1_SEQUENCE_ANY(NULL, &data, len);
    if (!seq) {
        std::cerr << "Failed to parse ASN.1 sequence" << std::endl;
        return 1;
    }

    ASN1_BIT_STRING* bitstr = ASN1_TYPE_unpack_sequence(ASN1_ITEM_rptr(RSA), seq);
    if (!bitstr) {
        std::cerr << "Failed to unpack ASN.1 bit string" << std::endl;
        ASN1_SEQUENCE_ANY_free(seq);
        return 1;
    }

    RSA* rsa = RSA_new();
    if (!rsa) {
        std::cerr << "Failed to create RSA object" << std::endl;
        ASN1_BIT_STRING_free(bitstr);
        ASN1_SEQUENCE_ANY_free(seq);
        return 1;
    }

    if (!RSA_asn1_meth_set1(rsa, bitstr)) {
        std::cerr << "Failed to set RSA ASN.1 method" << std::endl;
        RSA_free(rsa);
        ASN1_BIT_STRING_free(bitstr);
        ASN1_SEQUENCE_ANY_free(seq);
        return 1;
    }

    BIGNUM* n = BN_new();
    BIGNUM* e = BN_new();
    RSA_get0_key(rsa, &n, &e, NULL);

    std::cout << "n: " << BN_bn2hex(n) << std::endl;
    std::cout << "e: " << BN_bn2hex(e) << std::endl;

    RSA_free(rsa);
    ASN1_BIT_STRING_free(bitstr);
    ASN1_SEQUENCE_ANY_free(seq);
    return 0;
}