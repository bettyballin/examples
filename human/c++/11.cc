cpp
#include <cstdio>

size_t strlcpy(char *d, char const *s, size_t n)
{
    return snprintf(d, n, "%s", s);
}

size_t strlcat(char *d, char const *s, size_t n)
{
    return snprintf(d, n, "%s%s", d, s);
}

int main()
{
    char dest[20] = "";
    const char src[] = "Hello, World!";
    size_t len = strlcpy(dest, src, 20);
    printf("Copied string: %s\nLength: %zu\n", dest, len);

    const char append[] = " Appended!";
    len = strlcat(dest, append, 20);
    printf("Concatenated string: %s\nLength: %zu\n", dest, len);

    return 0;
}