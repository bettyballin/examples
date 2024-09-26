#include <stdio.h>

#define ele_cnt 10
#define ele_size 4

int main() {
    int i;

    for (i = 0; i <= ele_cnt; i++) {
        if (i * ele_size + ele_size > ele_cnt * ele_size) {
            printf("Error: Index out of bounds\n");
            break;
        } else {
            printf("Index %d is within bounds\n", i);
        }
    }

    return 0;
}