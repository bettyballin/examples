#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>

void* copy_elements(const void* ele_src[], int ele_cnt, size_t ele_size) {
    if (ele_cnt <= 0 || INT_MAX / ele_cnt < ele_size)
        return NULL;

    const size_t total = (size_t)ele_cnt * ele_size;

    void* result = malloc(total);

    if (result == NULL)
       /* malloc failed */
      return NULL;

   for (int i = 0; i < ele_cnt; i++) {
        memcpy(result, ele_src[i], ele_size);
        result += ele_size;
    }

    return result - total;
}

int main() {
    int arr1 = 10, arr2 = 20, arr3 = 30;
    const void* ele_src[] = {&arr1, &arr2, &arr3};
    int ele_cnt = 3;
    size_t ele_size = sizeof(int);

    void* result = copy_elements(ele_src, ele_cnt, ele_size);
    if (result != NULL) {
        for (int i = 0; i < ele_cnt; i++) {
            printf("%d ", *((int*)result + i));
        }
        printf("\n");
        free(result);
    }

    return 0;
}