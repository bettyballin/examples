/* test.c */
#include <stdio.h>

const char f[] = "\x55\x48\x89\xe5\x48\x89\x7d\xf8\x48\x89\x75\xf0\x48\x8b\x45\xf8\x8b\x10\x48\x8b\x45\xf0\x8b\x00\x89\xd1\x29\xc1\x89\xc8\xc9\xc3";

int main()
{
    int (*func)(int*, int*);
    func = (int (*)(int*, int*)) f;

    int x=3,y=5;
    printf("%d\n", func(&x, &y));
    return 0;
}