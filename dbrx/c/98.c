#include <stdio.h>

void setter(int i, size_t v, int a) {
    // do something with i, v, and a
}

int main()
{
    int i = 0;
    size_t v = 0;
    int a; // declare variable 'a'
    char buffer[100]; // declare and size the buffer

    puts("Enter a value for 'i':");
    if(fgets(buffer, sizeof(buffer), stdin) != NULL)
        sscanf(buffer, "%d", &i);

    puts("Enter a value for 'v':");
    if(fgets(buffer, sizeof(buffer), stdin) != NULL)
        sscanf(buffer, "%zu", &v);

    setter(i, v, a);
    return 0; // add return statement
}