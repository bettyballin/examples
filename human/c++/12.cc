cpp
#if defined __GNU_LIBRARY__ || defined __GLIBC__

size_t strlcpy(char *dst, char const *src, size_t size) {
    size_t len = 0;
    while (size-- && (*dst++ = *src++) != '\0') {
        len++;
    }
    if (size) {
        *dst = '\0';
    }
    while (*src++) {
        len++;
    }
    return len;
}

size_t strlcat(char *dst, char const *src, size_t size) {
    char *orig_dst = dst;
    size_t len = 0;
    while (size-- && *dst != '\0') {
        dst++;
    }
    while (size-- && (*dst++ = *src++) != '\0') {
        len++;
    }
    if (size) {
        *dst = '\0';
    }
    while (*src++) {
        len++;
    }
    return len + (dst - orig_dst);
}

int main() {
    char dst[10];
    char src[] = "Hello";
    size_t size = 10;

    size_t result1 = strlcpy(dst, src, size);
    printf("strlcpy result: %zu\n", result1);

    char dst2[10] = "World";
    size_t result2 = strlcat(dst2, src, size);
    printf("strlcat result: %zu\n", result2);

    return 0;
}

#endif