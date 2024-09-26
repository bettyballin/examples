#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

int main() {
    char *password, *guess, *salt = "$1$%%%%%%%%$";

    password = strdup(crypt(getpass("Enter Password1:"), salt));
    guess = strdup(crypt(getpass("Enter Password2:"), salt));

    if (strcmp(password, guess) == 0) {
        printf("Passwords match\n");
    } else {
        printf("Passwords do not match\n");
    }

    free(password);
    free(guess);

    return 0;
}