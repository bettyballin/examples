
#include <stdint.h>
#include <stddef.h>
#include <stdlib.h>
#include <string.h>

void *copy_elements(void *ele_src[], int ele_cnt, size_t ele_size) {
    /*
     * Check for integer overflow.
     */
    if
