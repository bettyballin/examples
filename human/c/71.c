#include <stdio.h>
#include <string.h>

#define BUF_SIZE 50

void print_data(char *buf) {
    printf("Data-1: %s\n", buf);
    printf("Data-2: %s\n", buf);
}

int main() {
    char buf[BUF_SIZE];
    strcpy(buf, "Z Help Z");

    while (fgets(buf, BUF_SIZE, stdin)) {
        buf[strcspn(buf, "\n")] = 0; // remove newline character
        print_data(buf);
    }

    return 0;
}