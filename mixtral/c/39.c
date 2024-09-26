#include <string.h>
#include <stdio.h>

void secure_erase(char *data) {
    errno_t result = memset_s((void *)data, strlen(data), 0, sizeof(*data));

    if (result != EOK)
        printf("Error: Secure erase failed\n");
}

int main() {
    char data[] = "Sensitive Data";
    printf("Original Data: %s\n", data);
    secure_erase(data);
    printf("Data after erase: %s\n", data);
    return 0;
}