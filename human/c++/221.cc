cpp
#include <iostream>
#include <string>
#include <openssl/ec.h>

int main() {
    EC_builtin_curve *curves;
    size_t crv_len = EC_get_builtin_curves(NULL, 0);
    curves = (EC_builtin_curve *)OPENSSL_malloc(sizeof(EC_builtin_curve) * crv_len);

    if (curves == NULL) {
        std::cerr << "Memory error" << std::endl;
        return 1;
    }

    EC_get_builtin_curves(curves, crv_len);

    for (size_t i = 0; i < crv_len; i++) {
        const char *name = OBJ_nid2sn(curves[i].nid);
        switch (curves[i].nid) {
            case NID_secp224r1:
                std::cout << "  " << name << " : NIST/SECG curve over a 224 bit prime field" << std::endl;
                break;
            case NID_secp256k1:
                std::cout << "  " << name << " : SECG curve over a 256 bit prime field" << std::endl;
                break;
            case NID_secp384r1:
                std::cout << "  " << name << " : NIST/SECG curve over a 384 bit prime field" << std::endl;
                break;
            case NID_secp521r1:
                std::cout << "  " << name << " : NIST/SECG curve over a 521 bit prime field" << std::endl;
                break;
            case NID_X9_62_prime256v1:
                std::cout << "  " << name << ": X9.62/SECG curve over a 256 bit prime field" << std::endl;
                break;
            default:
                std::cout << "  " << name << std::endl;
                break;
        }
    }

    OPENSSL_free(curves);

    return 0;
}