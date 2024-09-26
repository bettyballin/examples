#include <stdio.h>
#include <string.h>

int main(int argc, char **argv)
{
    char text[1024];
    static int some_value = -72;

    if (argc < 2) {
        printf("Usage: %s <input>\n", argv[0]);
        return 1;
    }

    strncpy(text, argv[1], 1023);
    text[1023] = '\0';

    printf("This is how you print correctly:\n");
    printf("%s\n", text);
    printf("This is how not to print:\n");
    printf("%s\n", text);

    printf("some_value @ 0x%p = %d [0x%x]\n", (void*)&some_value, some_value, some_value);
    return 0;
}