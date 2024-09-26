cpp
#include <stdio.h>
#include <openssl/ec.h>
#include <openssl/objects.h>

int main() {
    int ret = 1;
    EC_builtin_curve *curves = NULL;
    size_t n, crv_len = EC_get_builtin_curves(NULL, 0);

    curves = OPENSSL_malloc((int)sizeof(*curves) * crv_len);
    if (curves == NULL) {
        goto end;
    }

    if (!EC_get_builtin_curves(curves, crv_len)) {
        goto memfree;
    }

    for (n = 0; n < crv_len; n++) {
        const char *comment = curves[n].comment;
        const char *sname = OBJ_nid2sn(curves[n].nid);

        if (comment == NULL) {
            comment = "CURVE DESCRIPTION NOT AVAILABLE";
        }
        if (sname == NULL) {
            sname = "";
        }

        printf("%s\t%s\n", sname, comment);
    }
    ret = 0;

memfree:
    OPENSSL_free(curves);

end:
    return ret;
}