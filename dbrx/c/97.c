#include <stdio.h>
#include <limits.h>

void setter(size_t i, int v, int *a)
{
    if(i < 50 && (v <= INT_MAX))
        a[i] = v;
}

int main()
{
    int arr[50];
    setter(10, 20, arr);
    printf("%d\n", arr[10]);
    return 0;
}