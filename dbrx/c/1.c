#include <stdio.h>
#include <string.h>

void secure_foo(char *var, size_t max_length) {
    char safe_var[max_length + 1];

    // Use strncpy to ensure string length does not exceed the limit.
    strncpy(safe_var, var, max_length);
    safe_var[max_length] = '\0';

    printf("%s\n", safe_var);
}

int main() {
    char user_input[100];

    // Get input from the user
    fgets(user_input, sizeof(user_input), stdin);

    // Remove the newline character from the end of the string
    user_input[strcspn(user_input, "\n")] = 0;

    secure_foo(user_input, 49); // Limit output length to a maximum of 49 characters + null terminator.

    return 0;
}