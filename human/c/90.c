#include <stdio.h>
#include <openssl/engine.h>

int main() {
    ENGINE *e;
    ENGINE_load_builtin_engines();
    ENGINE_register_all_complete();

    if (!(e = ENGINE_by_id("cswift")))
        fprintf(stderr, "Error finding specified ENGINE\n");
    else if (!ENGINE_set_default(e, ENGINE_METHOD_ALL))
        fprintf(stderr, "Error using ENGINE\n");
    else
        fprintf(stderr, "Engine successfully enabled\n");

    ENGINE_free(e);
    return 0;
}


Compile with:
bash
gcc code.c -o code -lcrypto