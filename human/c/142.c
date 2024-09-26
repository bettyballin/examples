#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MEMORY_SIZE 100

int main() {
    int memory[MEMORY_SIZE];
    srand(time(NULL));

    printf("MEMORY: [");
    for (int i = 0; i < MEMORY_SIZE; i++) {
        memory[i] = rand() % 100;
        printf("%d", memory[i]);
        if (i < MEMORY_SIZE - 1) {
            printf(",");
        }
    }
    printf("]");

    return 0;
}