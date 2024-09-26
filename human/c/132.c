#include <stdio.h>
#include <string.h>

int main() {
    char searchstring[] = "test";
    unsigned long long rsp;
    asm volatile("mov %%rsp, %0" : "=r"(rsp));
    printf("%llx\n", (unsigned long long)rsp - (unsigned long long)searchstring);
    return 0;
}