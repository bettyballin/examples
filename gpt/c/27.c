
#include <stddef.h>
#include <string.h>

char * safer_strtrns(const char *string, const char *old, const char *new, char *result, size_t result_size) {
    if (!string || !old || !new || !result) return NULL;

    char *res_ptr = result;
    size_t res_space = result_size;
    const char *str_ptr;

    while (*string && res_space > 1) {
        str_ptr = strchr(old, *string);
        if (str_ptr) {
            size_t idx = str_ptr - old;
