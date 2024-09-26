#include <stdio.h>

#define ARRAY_SIZE 10

void setter(int i, int v, int * a){
    if (i >= 0 && i < ARRAY_SIZE) {
        a[i] = v;
    } else {
       printf("Error: Index out of bounds\n");
   }
}

int main() {
    int a[ARRAY_SIZE];
    setter(5, 10, a);
    printf("%d\n", a[5]);
    setter(15, 20, a);
    return 0;
}