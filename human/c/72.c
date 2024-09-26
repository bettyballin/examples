#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 1000

int main() {
    char data1[MAX];
    char data2[MAX];

    strcpy(data1, "Z Help Z");
    strcpy(data2, "a aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa Z");

    printf("%s\n", data1);
    printf("%s\n", data2);

    return 0;
}