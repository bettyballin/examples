#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main(){

    char message[] = "Pizza is great!";
    printf("sizeof(message) is %ld\n", sizeof(message));
    printf("strlen(message) is %ld\n", (long)strlen(message));

    return 0;
}