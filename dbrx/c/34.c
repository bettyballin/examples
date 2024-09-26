#include <stdio.h>

int main(int argc, char* argv[]) {
    printf("Address: %p\n", (void*)argv[0]);
    return 0;
}