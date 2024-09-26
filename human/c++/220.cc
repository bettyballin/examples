cpp
#include <iostream>
#include <openssl/ec.h>

int main() {
    EC_builtin_curve *curves;
    size_t crv_len = EC_get_builtin_curves(NULL, 0);
    curves = (EC_builtin_curve *)OPENSSL_malloc(sizeof(EC_builtin_curve) * crv_len);
    EC_get_builtin_curves(curves, crv_len);

    for (size_t i = 0; i < crv_len; i++) {
        std::cout << curves[i].comment << "       " << curves[i].name << std::endl;
    }

    OPENSSL_free(curves);

    return 0;
}