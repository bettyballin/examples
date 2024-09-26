#include <stdio.h>

typedef int another_type;
typedef int some_type;

some_type function_name(another_type x) {
    return x * 2;
}

int main() {
    another_type x = 5;
    some_type result = function_name(x);
    printf("%d\n", result);
    return 0;
}