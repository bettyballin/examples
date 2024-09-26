#include <stdlib.h>
#include <string.h>

void *copy_elements(const void *ele_src[], int ele_cnt, size_t ele_size) 
{ 
    void *result;

    if (ele_cnt <= 0 || ele_size == 0) {
        return NULL;
    }

    if ((result = malloc(ele_cnt * ele_size)) == NULL) {
        return NULL;
    }

    for (int i = 0; i < ele_cnt; i++) {
        memcpy(result + i * ele_size, ele_src[i], ele_size);
    }

    return result;
}

int main() {
    int arr[] = {1, 2, 3, 4, 5};
    int *ptrs[] = {&arr[0], &arr[1], &arr[2], &arr[3], &arr[4]};
    int *result = copy_elements(ptrs, 5, sizeof(int));

    if (result != NULL) {
        for (int i = 0; i < 5; i++) {
            printf("%d ", *(result + i));
        }
        printf("\n");
        free(result);
    }

    return 0;
}